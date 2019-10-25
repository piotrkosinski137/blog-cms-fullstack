package com.blogen.posts.controller

import com.blogen.categories.domain.Category
import com.blogen.commons.PageDTO
import com.blogen.posts.domain.Post
import com.blogen.posts.usecase.LoadPosts
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import spock.lang.Specification

import java.time.LocalDateTime

class LoadPostsControllerTest extends Specification {

    final def loadPosts = Mock(LoadPosts)
    final def postsController = new LoadPostsController(loadPosts)

    def "should map spring page into custom page with posts dto"() {
        given:
                def category = [title: "title"] as Category
        def post1 = new Post("title", "image.jpg", "lorem.."
                , LocalDateTime.of(1111, 11, 11, 11, 11), category)

        Page<Post> page = Mock(Page)
        page.getTotalElements() >> 1
        page.getTotalPages() >> 1
        page.getContent() >> [post1]

        loadPosts.loadPage(PageRequest.of(0,1)) >> page

        when:
        def customPage = postsController.loadPage(0, 1)

        then:
        customPage.getTotalPages() == page.getTotalElements()
        customPage.getTotalPages() == page.getTotalPages()
        customPage.getElements()[0] == [title: "title",
                               imageName: "image.jpg",
                               article: "lorem..",
                               localDateAdded: "1111-11-11 11:11:00",
                               categoryTitle: "title"] as PostDTO

    }
}
