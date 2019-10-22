import {ActionReducerMap} from "@ngrx/store";
import * as fromAuth from "./commons/auth/store/auth.reducers";
import * as fromCategories from "./components/dashboard/categories/store/categories.reducers";
import * as fromPosts from "./components/dashboard/posts/store/posts.reducers";

export interface AppState {
  auth: fromAuth.AuthState
  categories: fromCategories.CategoriesState
  posts: fromPosts.PostsState
}

export const appReducer: ActionReducerMap<AppState> = {
  auth: fromAuth.authReducer,
  categories: fromCategories.categoriesReducer,
  posts: fromPosts.postsReducer
};
