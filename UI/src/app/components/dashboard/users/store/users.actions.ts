import {Action} from "@ngrx/store";
import {User} from "../../../../model/user";
import {PageRequest} from "../../../../model/page.request";
import {PageResponse} from "../../../../model/page.response";

export enum UsersActionTypes {
  TRY_LOAD_USERS_PAGE = "[users] try load users",
  LOAD_USERS_PAGE_SUCCESS = "[users] load users success",
  LOAD_USERS_PAGE_FAILED = "[users] load users failed"
}

export class TryLoadUsers implements Action {
  readonly type = UsersActionTypes.TRY_LOAD_USERS_PAGE;
  constructor(public pageRequest: PageRequest) {
  }
}

export class LoadUsersSuccess implements Action {
  readonly type = UsersActionTypes.LOAD_USERS_PAGE_SUCCESS;

  constructor(public pageResponse: PageResponse<User>) {
  }
}

export class LoadUsersFailed implements Action {
  readonly type = UsersActionTypes.LOAD_USERS_PAGE_FAILED;
}

export type UsersActions =
  TryLoadUsers |
  LoadUsersSuccess |
  LoadUsersFailed
