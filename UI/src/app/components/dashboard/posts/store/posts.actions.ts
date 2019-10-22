import {Action} from "@ngrx/store";
import {PageRequest} from "../../../../model/page.request";
import {PageResponse} from "../../../../model/page.response";
import {Post} from "../../../../model/post";


export enum PostsActionTypes {
  TRY_LOAD_POSTS_PAGE = '[posts] try load posts page',
  LOAD_POSTS_PAGE_SUCCESS = '[posts] load posts page success',
  LOAD_POSTS_PAGE_FAILED = '[posts] load posts page failed',
}


export class TryLoadPostsPage implements Action {
  readonly type = PostsActionTypes.TRY_LOAD_POSTS_PAGE;

  constructor(public pageRequest: PageRequest) {
  }
}

export class LoadPostsPageSuccess implements Action {
  readonly type = PostsActionTypes.LOAD_POSTS_PAGE_SUCCESS;

  constructor(public pageResponse: PageResponse<Post>) {
  }
}

export class LoadPostsPageFailed implements Action {
  readonly type = PostsActionTypes.LOAD_POSTS_PAGE_FAILED;
}

export type PostsActions =
  TryLoadPostsPage |
  LoadPostsPageSuccess |
  LoadPostsPageFailed
