import {AuthActions, AuthActionsTypes} from "./auth.actions";

export interface AuthState {
  username: string,
  token: string,
  role: string
}

export const initState: AuthState = {
  username: undefined,
  token: undefined,
  role: undefined
};


export function authReducer(state = initState, action: AuthActions) {
  switch (action.type) {
    case AuthActionsTypes.LOG_OUT: {
      return {
        ...state,
        username : undefined,
        token : undefined,
        role : undefined
      }
    }
    case AuthActionsTypes.LOG_IN_SUCCESS: {
      return {
        ...state,
        username : action.response.username,
        token : action.response.token,
        role : action.response.role
      }
    }
    default:
      return state;
  }
}
