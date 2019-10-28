import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidatorFn, Validators} from "@angular/forms";
import {AuthState} from "../../commons/auth/store/auth.reducers";
import {select, Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {getRole} from "../../commons/auth/store/auth.selectors";
import * as authActions from "../../commons/auth/store/auth.actions"
import {Role} from "../../model/user";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  public DropDownRoles = Role;
  role$: Observable<string>;

  userModal = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(30), Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(4), Validators.maxLength(20)]),
    confirmPassword: new FormControl('', [Validators.required, Validators.minLength(4), Validators.maxLength(20)]),
    role: new FormControl('', [Validators.required])
  });

  constructor(private store: Store<AuthState>) {
  }

  ngOnInit() {
    this.role$ = this.store.pipe(select(getRole));
  }

  onCreateUserClick() {
    this.store.dispatch(new authActions.TryRegisterUser(
      {
        email: this.userModal.get('email').value,
        password: this.userModal.get('password').value,
        confirmPassword: this.userModal.get('confirmPassword').value,
        role: this.userModal.get('role').value.value
      }));

    //this.userModal.reset();

  }
}

//Idea how to create custom validator but dunno how to pass live data into it. I use it during initialization of
// form group
function arePasswordsEqual(password: string, confirmPassword: string): ValidatorFn {
  return (control: AbstractControl): { [key: string]: boolean } | null => {
    if (password === confirmPassword) {
      return {'passwordNotEqual': true};
    }
    return null;
  };
}
