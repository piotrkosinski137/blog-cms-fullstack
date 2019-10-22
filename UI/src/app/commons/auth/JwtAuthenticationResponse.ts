export class JwtAuthenticationResponse {
  constructor(public token: string, public username: string, public role: string) {
  }
}
