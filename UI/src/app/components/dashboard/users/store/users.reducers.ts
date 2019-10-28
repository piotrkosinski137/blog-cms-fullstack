import {User} from "../../../../model/user";
import {UsersActions, UsersActionTypes} from "./users.actions";

export interface UsersState {
  users: User[]
  totalPages: number,
  currentPage: number
}

export const initState: UsersState =
  {
    users: [],
    totalPages: undefined,
    currentPage: undefined
  };

export function usersReducer(state = initState, action: UsersActions) {
  switch(action.type) {
    case UsersActionTypes.LOAD_USERS_PAGE_SUCCESS: {
      return {
        ...state,
        users: action.pageResponse.elements,
        totalPages: action.pageResponse.totalPages
      }
    }

    default:
      return state;
  }
}
