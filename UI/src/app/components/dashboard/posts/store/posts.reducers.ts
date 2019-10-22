import {Post} from "../../../../model/post";
import {PostsActions, PostsActionTypes} from "./posts.actions";


export interface PostsState {
  posts: Post[]
  totalPages: number,
  currentPage: number
}

export const initialState: PostsState = {
  posts: [],
  totalPages: undefined,
  currentPage: undefined
};


export function postsReducer(state = initialState, action: PostsActions) {
  switch (action.type) {
    case PostsActionTypes.TRY_LOAD_POSTS_PAGE: {
      return {
        ...state,
        currentPage: action.pageRequest.page
      }
    }
    case PostsActionTypes.LOAD_POSTS_PAGE_SUCCESS: {
      return {
        ...state,
        posts: action.pageResponse.content,
        totalPages: action.pageResponse.totalPages
      }
    }
    default:
      return state;
  }
}
