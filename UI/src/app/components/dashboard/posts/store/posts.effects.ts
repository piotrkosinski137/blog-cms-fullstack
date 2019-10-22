import {Injectable} from "@angular/core";
import {Actions, Effect, ofType} from "@ngrx/effects";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {Observable, of} from "rxjs";
import {Action} from "@ngrx/store";
import {catchError, map, mergeMap} from "rxjs/operators";
import {PageResponse} from "../../../../model/page.response";
import {HttpErrorResponse} from "@angular/common/http";
import {PostsActionTypes, TryLoadPostsPage} from "./posts.actions";
import {PostsService} from "../posts.service";
import {Post} from "../../../../model/post";
import * as postsActions from "../store/posts.actions"

@Injectable()
export class PostsEffects {
  constructor(private actions$: Actions, private router: Router, private postsService: PostsService,
              private toastrService: ToastrService) {
  }

  @Effect()
  getPostsPage: Observable<Action> = this.actions$.pipe(ofType(PostsActionTypes.TRY_LOAD_POSTS_PAGE),
    mergeMap((actionInput: TryLoadPostsPage) =>
      this.postsService.loadPostsPage(actionInput.pageRequest).pipe(
        map((response: PageResponse<Post>) => {
          return new postsActions.LoadPostsPageSuccess(response)
        })
      )
    ), catchError((response: HttpErrorResponse) => {
      this.toastrService.error(response.error, 'Loading posts failed');

      return of(null)
      // return of(new authActions.LoginFailed())
    })
  )
}
