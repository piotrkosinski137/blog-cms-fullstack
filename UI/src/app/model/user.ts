export interface User {
  id?: string,
  email: string,
  password?: string,
  role?: string
}

export enum Role {
  admin = "ADMIN",
  user = "USER"
}
