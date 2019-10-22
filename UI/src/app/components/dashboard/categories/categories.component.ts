import { Component, OnInit } from '@angular/core';
import {Category} from "../../../model/category";
import {select, Store} from "@ngrx/store";
import * as categoriesActions from "./store/categories.actions"
import {CategoriesState} from "./store/categories.reducers";
import {Observable} from "rxjs";
import {getCategories} from "./store/categories.selectors";

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.scss']
})
export class CategoriesComponent implements OnInit {

  categories$: Observable<Category[]>;

  constructor(private store: Store<CategoriesState>) { }

  ngOnInit() {
    this.store.dispatch(new categoriesActions.TryLoadCategoriesPage({size: 2, page: 0}))
    this.categories$ = this.store.pipe(select(getCategories));
  }

}
