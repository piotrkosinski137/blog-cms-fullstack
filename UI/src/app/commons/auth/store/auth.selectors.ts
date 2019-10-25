import {AuthState} from "./auth.reducers";
import {createFeatureSelector, createSelector} from "@ngrx/store";

export const getAuthFeatureState = createFeatureSelector<AuthState>(
  "auth"
);

export const getUsername = createSelector(
  getAuthFeatureState,
  (state: AuthState) => state.username
);

export const getToken = createSelector(
  getAuthFeatureState,
  (state: AuthState) => state.token
);

export const getRole = createSelector(
  getAuthFeatureState,
  (state: AuthState) => state.role
);
