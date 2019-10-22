import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {PostsComponent} from "./components/dashboard/posts/posts.component";
import {CategoriesComponent} from "./components/dashboard/categories/categories.component";
import {UsersComponent} from "./components/dashboard/users/users.component";
import {EditPostComponent} from "./components/dashboard/posts/editpost/edit-post.component";
import {ProfileComponent} from "./components/dashboard/users/profile/profile.component";
import {LoginComponent} from "./components/dashboard/users/login/login.component";
import {AuthGuardService} from "./commons/auth/auth-guard.service";
import {CategoryDetailsComponent} from "./components/dashboard/categories/category-details/category-details.component";

const routes: Routes = [
  {path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuardService]},
  {path: 'categories', component: CategoriesComponent, canActivate: [AuthGuardService]},
  {path: 'categories/:id', component: CategoryDetailsComponent, canActivate: [AuthGuardService]},
  {path: 'login', component: LoginComponent},
  {path: 'profile', component: ProfileComponent, canActivate: [AuthGuardService]},
  {path: 'posts', component: PostsComponent, canActivate: [AuthGuardService],
  children : [
    {path: ':id', component: EditPostComponent},
  ]
  },
  {path: 'users', component: UsersComponent, canActivate: [AuthGuardService]},
  {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
