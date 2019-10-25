import {Injectable} from '@angular/core';
import {JwtAuthenticationRequest} from "./JwtAuthenticationRequest";
import {HttpClient} from "@angular/common/http";
import {JwtAuthenticationResponse} from "./JwtAuthenticationResponse";
import {Observable} from "rxjs";
import {User} from "../../model/user";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {
  }

  public login(request: JwtAuthenticationRequest): Observable<JwtAuthenticationResponse> {
    return this.http.post<JwtAuthenticationResponse>('/api/auth', request);
  }

  public register(user: User): Observable<User> {
    return this.http.post<any>('/api/user/register', user);
  }
}
