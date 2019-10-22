import {createFeatureSelector, createSelector} from "@ngrx/store";
import {CategoriesState} from "./categories.reducers";

export const getCategoriesFeatureState = createFeatureSelector<CategoriesState>(
  "categories"
);

export const getCategories = createSelector(
  getCategoriesFeatureState,
  (state: CategoriesState) => state.categories
);

export const getCategoryById = createSelector(
  getCategoriesFeatureState,
  (state: CategoriesState, properties) => {
    return state.categories.find(category => category.id === +properties.id)
  }
);
