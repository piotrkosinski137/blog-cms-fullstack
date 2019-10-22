import {Injectable} from '@angular/core';
import {CanActivate, Router} from "@angular/router";
import {select, Store} from "@ngrx/store";
import {AuthState} from "./store/auth.reducers";
import {getToken} from "./store/auth.selectors";

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {
  token: string;

  constructor(private store: Store<AuthState>, private router: Router) {
  }

  canActivate(): boolean {
    this.store.pipe(select(getToken)).subscribe(result => this.token = result);

    if (this.token === undefined) {
      this.router.navigate(['login']);
      return false;
    }
    return true;
  }
}
