import {Category} from "../../../../model/category";
import {CategoriesActions, CategoriesActionsTypes} from "./categories.actions";

export interface CategoriesState {
  categories: Category[],
  totalPages: number,
  currentPage: number
}


export const initialState: CategoriesState = {
  categories: [],
  totalPages: undefined,
  currentPage: undefined
};

export function categoriesReducer(state = initialState, action: CategoriesActions) {
  switch (action.type) {
    case CategoriesActionsTypes.TRY_LOAD_CATEGORIES_PAGE: {
      return {
        ...state,
        currentPage : action.pageRequest.page
      }
    }
    case CategoriesActionsTypes.LOAD_CATEGORIES_PAGE_SUCCESS: {
      return {
        ...state,
        totalPages: action.pageResponse.totalPages,
        categories: action.pageResponse.elements
      }
    }
    default:
      return state;
  }
}
