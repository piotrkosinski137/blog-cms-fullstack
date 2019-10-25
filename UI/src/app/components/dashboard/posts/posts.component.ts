import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Post} from "../../../model/post";
import {PostsState} from "./store/posts.reducers";
import {select, Store} from "@ngrx/store";
import * as postsActions from "../posts/store/posts.actions"
import {getCurrentPage, getPosts, getTotalPages} from "./store/posts.selectors";

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.scss']
})
export class PostsComponent implements OnInit {
  currentPage: number;
  totalPages: number;
  shouldShowPostDetails = false;
  post: Post;

  posts$: Observable<Post[]>;

  constructor(private store: Store<PostsState>) {
  }

  ngOnInit() {
    this.store.dispatch(new postsActions.TryLoadPostsPage({page: 0, size: 3}));
    this.posts$ = this.store.pipe(select(getPosts));

    this.store.pipe(select(getCurrentPage)).subscribe(result => this.currentPage = result);
    this.store.pipe(select(getTotalPages)).subscribe(result => this.totalPages = result);
  }

  loadPostDetails(post: Post) {
    this.post = post;
    this.shouldShowPostDetails = true;
  }

  getCurrentPageNumber(pageDifference: number) {
    return this.currentPage + 1 + pageDifference;
  }

  getLastPageNumber() {
    return this.totalPages;
  }

  onNextPageClicked(pageDifference: number) {
    this.shouldShowPostDetails = false;
    this.store.dispatch(new postsActions.TryLoadPostsPage({page: this.currentPage + pageDifference, size: 2}));
  }

  onDeletePostClick(id: number) {
    this.shouldShowPostDetails = false;
    this.store.dispatch(new postsActions.TryDeletePost(id));
  }
}
