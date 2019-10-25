package com.blogen.posts.controller

import com.blogen.categories.domain.Category
import com.blogen.posts.domain.Post
import spock.lang.Specification

import java.time.LocalDateTime

class PostMapperTest extends Specification {

    final def mapper = PostMapper.initialize()

    def "should correctly map post to DTO"() {
        given:
        def category = [title: "title"] as Category
        def post = new Post("title", "image.jpg", "lorem.."
                , LocalDateTime.of(1111, 11, 11, 11, 11), category)

        when:
        PostDTO postDTO = mapper.map(post, PostDTO.class)

        then:
        with(postDTO) {
            getTitle() == post.getTitle()
            getImageName() == post.getImageName()
            getArticle() == post.getArticle()
            getLocalDateAdded() == "1111-11-11 11:11:00"
            getCategoryTitle() == post.getCategory().getTitle()
        }
    }
}
