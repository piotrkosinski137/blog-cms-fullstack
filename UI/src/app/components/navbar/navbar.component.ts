import { Component, OnInit } from '@angular/core';
import * as authActions from '../../commons/auth/store/auth.actions'
import {select, Store} from "@ngrx/store";
import {getUsername} from "../../commons/auth/store/auth.selectors";
import {Observable} from "rxjs";
import {AuthState} from "../../commons/auth/store/auth.reducers";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  username$: Observable<string>;

  constructor(private store: Store<AuthState>, private router: Router) { }

  ngOnInit() {
    this.username$ = this.store.pipe(select(getUsername))
  }

  onLogoutClick() {
    this.store.dispatch(new authActions.LogOut());
    this.router.navigate(['/login'])
  }
}
