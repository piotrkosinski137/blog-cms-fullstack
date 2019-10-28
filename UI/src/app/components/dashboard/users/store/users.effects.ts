import {Injectable} from "@angular/core";
import {Actions, Effect, ofType} from "@ngrx/effects";
import {Observable, of} from "rxjs";
import {Action} from "@ngrx/store";
import {catchError, exhaustMap, map} from "rxjs/operators";
import {PageResponse} from "../../../../model/page.response";
import {HttpErrorResponse} from "@angular/common/http";
import {TryLoadUsers, UsersActionTypes} from "./users.actions";
import {UsersService} from "../users.service";
import {User} from "../../../../model/user";
import * as usersActions from "../store/users.actions"
import {ToastrService} from "ngx-toastr";


@Injectable()
export class UsersEffects {

  constructor(private actions$: Actions, private usersService: UsersService, private toastrService: ToastrService) {
  }

  @Effect()
  getUsers: Observable<Action> = this.actions$.pipe(ofType(UsersActionTypes.TRY_LOAD_USERS_PAGE),
    exhaustMap((actionInput: TryLoadUsers) =>
      this.usersService.loadUsersPage(actionInput.pageRequest).pipe(
        map((response: PageResponse<User>) => {
          return new usersActions.LoadUsersSuccess(response)
        })
      )
    ), catchError((response: HttpErrorResponse) => {
      this.toastrService.error(response.message, 'Loading users failed');
      return of(new usersActions.LoadUsersFailed())
    })
  );
}
