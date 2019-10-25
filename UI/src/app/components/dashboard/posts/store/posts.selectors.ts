import {createFeatureSelector, createSelector} from "@ngrx/store";
import {PostsState} from "./posts.reducers";

export const getPostsFeatureState = createFeatureSelector<PostsState>(
  "posts"
);

export const getPosts = createSelector(
  getPostsFeatureState,
  (state: PostsState) => state.posts
);

export const getTotalPages = createSelector(
  getPostsFeatureState,
  (state: PostsState) => state.totalPages
);

export const getCurrentPage = createSelector(
  getPostsFeatureState,
  (state: PostsState) => state.currentPage
);
