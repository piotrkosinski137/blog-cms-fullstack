import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Post} from "../../../model/post";
import {PostsState} from "./store/posts.reducers";
import {select, Store} from "@ngrx/store";
import * as postsActions from "../posts/store/posts.actions"
import {getPosts} from "./store/posts.selectors";

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.scss']
})
export class PostsComponent implements OnInit {

  shouldShowPostDetails = false;

  posts$: Observable<Post[]>;

  constructor(private store: Store<PostsState>) {
  }

  ngOnInit() {
    this.store.dispatch(new postsActions.TryLoadPostsPage({page: 0, size: 3}))
    this.posts$ = this.store.pipe(select(getPosts))
  }

  loadPostDetails() {
    this.shouldShowPostDetails = true;
  }
}
