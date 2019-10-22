import {Injectable} from "@angular/core";
import {Actions, Effect, ofType} from "@ngrx/effects";
import * as authActions from "./auth.actions";
import {JwtAuthenticationResponse} from "../JwtAuthenticationResponse";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";
import {AuthService} from "../auth.service";
import {Observable, of} from "rxjs";
import {Action} from "@ngrx/store";
import {AuthActionsTypes, TryLogIn} from "./auth.actions";
import {catchError, map, mergeMap} from "rxjs/operators";
import {HttpErrorResponse} from "@angular/common/http";

@Injectable()
export class AuthEffects {
  constructor(private actions$: Actions, private router: Router,
              private authService: AuthService, private toastrService: ToastrService) {

  }

  @Effect()
  login: Observable<Action> = this.actions$.pipe(ofType(AuthActionsTypes.TRY_LOG_IN),
    mergeMap((actionInput: TryLogIn) =>
      this.authService.login(actionInput.credentials).pipe(
        map((response: JwtAuthenticationResponse) => {
          this.router.navigate(['/dashboard']);
          return new authActions.LoginSuccess(response)
        })
      )
    ), catchError((response: HttpErrorResponse) => {
      console.log(response.error);
      this.toastrService.error(response.error, 'Login failed');
      setTimeout(function () {
        window.location.reload();
      }, 1500);
      return of(null)
      // return of(new authActions.LoginFailed())
    })
  );
}
