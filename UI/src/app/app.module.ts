import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavbarComponent} from './components/navbar/navbar.component';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {PostsComponent} from './components/dashboard/posts/posts.component';
import {CategoriesComponent} from './components/dashboard/categories/categories.component';
import {UsersComponent} from './components/dashboard/users/users.component';
import {EditPostComponent} from './components/dashboard/posts/editpost/edit-post.component';
import {ProfileComponent} from './components/dashboard/users/profile/profile.component';
import {LoginComponent} from './components/dashboard/users/login/login.component';
import {StoreModule} from "@ngrx/store";
import {StoreDevtoolsModule} from "@ngrx/store-devtools";
import {environment} from "../environments/environment";
import {appReducer} from "./app.reducer";
import {AuthEffects} from "./commons/auth/store/auth.effects";
import {EffectsModule} from "@ngrx/effects";
import {ReactiveFormsModule} from "@angular/forms";
import {ToastrModule} from "ngx-toastr";
import {BrowserModule} from "@angular/platform-browser";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {CategoriesEffects} from "./components/dashboard/categories/store/categories.effects";
import {TokenInterceptor} from "./commons/auth/token.interceptor";
import { CategoryDetailsComponent } from './components/dashboard/categories/category-details/category-details.component';
import {PostsEffects} from "./components/dashboard/posts/store/posts.effects";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {UsersEffects} from "./components/dashboard/users/store/users.effects";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    DashboardComponent,
    PostsComponent,
    CategoriesComponent,
    UsersComponent,
    EditPostComponent,
    ProfileComponent,
    LoginComponent,
    CategoryDetailsComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    StoreModule.forRoot(appReducer),
    StoreDevtoolsModule.instrument({
      logOnly: environment.production
    }),
    EffectsModule.forRoot([AuthEffects, CategoriesEffects, PostsEffects, UsersEffects])
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
