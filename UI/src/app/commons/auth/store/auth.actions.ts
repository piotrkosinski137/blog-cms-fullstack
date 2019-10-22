import {Action} from "@ngrx/store";
import {JwtAuthenticationRequest} from "../JwtAuthenticationRequest";
import {JwtAuthenticationResponse} from "../JwtAuthenticationResponse";

export enum AuthActionsTypes {
  TRY_LOG_IN = '[auth] try to log in',
  LOG_IN_SUCCESS = '[auth] log in success',
  LOG_OUT = '[auth] log out'
}

export class LogOut implements Action {
  readonly type = AuthActionsTypes.LOG_OUT
}

export class TryLogIn implements Action {
  readonly type = AuthActionsTypes.TRY_LOG_IN;

  constructor(public credentials: JwtAuthenticationRequest) {
  }
}

export class LoginSuccess implements Action {
  readonly type = AuthActionsTypes.LOG_IN_SUCCESS;

  constructor(public response: JwtAuthenticationResponse) {
  }
}

export type AuthActions =
  TryLogIn |
  LoginSuccess |
  LogOut
