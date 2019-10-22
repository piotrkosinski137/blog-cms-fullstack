import {Action} from "@ngrx/store";
import {PageRequest} from "../../../../model/page.request";
import {PageResponse} from "../../../../model/page.response";
import {Category} from "../../../../model/category";

export enum CategoriesActionsTypes {
  TRY_LOAD_CATEGORIES_PAGE = '[categories] try load categories page',
  LOAD_CATEGORIES_PAGE_SUCCESS = '[categories] load categories page success',
  LOAD_CATEGORIES_PAGE_FAILED = '[categories] load categories page failed'
}


export class TryLoadCategoriesPage implements Action {
  readonly type = CategoriesActionsTypes.TRY_LOAD_CATEGORIES_PAGE;

  constructor(public pageRequest: PageRequest) {
  }
}

export class LoadCategoriesPageSuccess implements Action {
  readonly type = CategoriesActionsTypes.LOAD_CATEGORIES_PAGE_SUCCESS

  constructor(public pageResponse: PageResponse<Category>) {
  }
}

export class LoadCategoriesPageFailed implements Action {
  readonly type = CategoriesActionsTypes.LOAD_CATEGORIES_PAGE_FAILED
}

export type CategoriesActions =
  TryLoadCategoriesPage |
  LoadCategoriesPageSuccess |
  LoadCategoriesPageFailed
