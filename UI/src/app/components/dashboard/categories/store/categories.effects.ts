import {Injectable} from "@angular/core";
import {Actions, Effect, ofType} from "@ngrx/effects";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {Observable, of} from "rxjs";
import {Action} from "@ngrx/store";
import {catchError, map, mergeMap} from "rxjs/operators";
import {HttpErrorResponse} from "@angular/common/http";
import {CategoriesService} from "../categories.service";
import {CategoriesActionsTypes, TryLoadCategoriesPage} from "./categories.actions";
import {PageResponse} from "../../../../model/page.response";
import {Category} from "../../../../model/category";
import * as categoriesActions from "../store/categories.actions"


@Injectable()
export class CategoriesEffects {
  constructor(private actions$: Actions, private router: Router, private categoriesService: CategoriesService,
              private toastrService: ToastrService) {
  }

  @Effect()
  getCategoriesPage: Observable<Action> = this.actions$.pipe(ofType(CategoriesActionsTypes.TRY_LOAD_CATEGORIES_PAGE),
    mergeMap((actionInput: TryLoadCategoriesPage) =>
      this.categoriesService.loadCategoriesPage(actionInput.pageRequest).pipe(
        map((response: PageResponse<Category>) => {
          return new categoriesActions.LoadCategoriesPageSuccess(response)
        })
      )
    ), catchError((response: HttpErrorResponse) => {
      this.toastrService.error(response.error, 'Loading categories failed');

      return of(null)
      // return of(new authActions.LoginFailed())
    })
  );
}
