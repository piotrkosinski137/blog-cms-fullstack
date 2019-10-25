import {Action} from "@ngrx/store";
import {JwtAuthenticationRequest} from "../JwtAuthenticationRequest";
import {JwtAuthenticationResponse} from "../JwtAuthenticationResponse";
import {User} from "../../../model/user";

export enum AuthActionsTypes {
  TRY_LOG_IN = '[auth] try to log in',
  LOG_IN_SUCCESS = '[auth] log in success',
  LOG_OUT = '[auth] log out',
  TRY_REGISTER_USER = '[users] try register users',
  REGISTER_USER_SUCCESS = '[users] register user success',
  REGISTER_USER_FAILED = '[users] register user failed',
}

export class LogOut implements Action {
  readonly type = AuthActionsTypes.LOG_OUT
}

export class TryLogIn implements Action {
  readonly type = AuthActionsTypes.TRY_LOG_IN;

  constructor(public credentials: JwtAuthenticationRequest) {
  }
}

export class TryRegisterUser implements Action {
  readonly type = AuthActionsTypes.TRY_REGISTER_USER;

  constructor(public user: User) {
  }
}

export class RegisterUserSuccess implements Action {
  readonly type = AuthActionsTypes.REGISTER_USER_SUCCESS;
}

export class RegisterUserFailed implements Action {
  readonly type = AuthActionsTypes.REGISTER_USER_FAILED;
}

export class LoginSuccess implements Action {
  readonly type = AuthActionsTypes.LOG_IN_SUCCESS;

  constructor(public response: JwtAuthenticationResponse) {
  }
}

export type AuthActions =
  TryLogIn |
  LoginSuccess |
  LogOut |
  TryRegisterUser |
  RegisterUserSuccess |
  RegisterUserFailed
