import {Component, OnInit} from '@angular/core';
import {Store} from "@ngrx/store";
import * as authActions from "../../../../commons/auth/store/auth.actions"
import {JwtAuthenticationRequest} from "../../../../commons/auth/JwtAuthenticationRequest";
import {AuthState} from "../../../../commons/auth/store/auth.reducers";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  credentialsForm = new FormGroup({
    email: new FormControl('a@o2.pl', [Validators.required, Validators.minLength(5), Validators.maxLength(20), Validators.email]),
    password: new FormControl('admin', [Validators.required, Validators.minLength(4), Validators.maxLength(20)])
  });

  constructor(private store: Store<AuthState>) {
  }

  ngOnInit() {
  }

  onLoginClick() {
    this.store.dispatch(new authActions
      .TryLogIn(new JwtAuthenticationRequest(this.credentialsForm.value.email, this.credentialsForm.value.password)));
  }

}
