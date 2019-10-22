import {createFeatureSelector, createSelector} from "@ngrx/store";
import {PostsState} from "./posts.reducers";

export const getPostsFeatureState = createFeatureSelector<PostsState>(
  "posts"
);

export const getPosts = createSelector(
  getPostsFeatureState,
  (state: PostsState) => state.posts
);
