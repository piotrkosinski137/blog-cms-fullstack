import {Injectable} from "@angular/core";
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {AuthState} from "./store/auth.reducers";
import {select, State} from "@ngrx/store";
import {getToken} from "./store/auth.selectors";

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  token: string;

  constructor(private store: State<AuthState>) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    this.store.pipe(select(getToken)).subscribe(result => this.token = result);

    if (this.token !== undefined) {
      request = request.clone({
        setHeaders: {
          Authorization: "Bearer " + this.token
        }
      });
    }
    return next.handle(request);
  }

  // hinweis what to do to force log in when token expires
  //https://medium.com/@ryanchenkie_40935/angular-authentication-using-the-http-client-and-http-interceptors-2f9d1540eb8
}

