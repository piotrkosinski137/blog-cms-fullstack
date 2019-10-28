import {ActionReducerMap} from "@ngrx/store";
import * as fromAuth from "./commons/auth/store/auth.reducers";
import * as fromCategories from "./components/dashboard/categories/store/categories.reducers";
import * as fromPosts from "./components/dashboard/posts/store/posts.reducers";
import * as fromUsers from "./components/dashboard/users/store/users.reducers";

export interface AppState {
  auth: fromAuth.AuthState
  categories: fromCategories.CategoriesState
  posts: fromPosts.PostsState
  users: fromUsers.UsersState
}

export const appReducer: ActionReducerMap<AppState> = {
  auth: fromAuth.authReducer,
  categories: fromCategories.categoriesReducer,
  posts: fromPosts.postsReducer,
  users: fromUsers.usersReducer
};
