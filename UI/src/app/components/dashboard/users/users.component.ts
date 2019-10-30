import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {User} from "../../../model/user";
import {UsersState} from "./store/users.reducers";
import {select, Store} from "@ngrx/store";
import * as userActions from "../users/store/users.actions"
import {getUsers} from "./store/users.selectors";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  users$: Observable<User[]>;

  constructor(private store: Store<UsersState>) { }

  ngOnInit() {
    this.store.dispatch(new userActions.TryLoadUsers({page: 0, size: 3}));
    this.users$ = this.store.pipe(select(getUsers))
  }

}
