import {createFeatureSelector, createSelector} from "@ngrx/store";
import {UsersState} from "./users.reducers";

export const getUsersFeatureState = createFeatureSelector<UsersState>(
  "users"
);

export const getUsers = createSelector(
  getUsersFeatureState,
  (state: UsersState) => state.users
);
