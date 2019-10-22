import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CategoriesState} from "../store/categories.reducers";
import {select, State} from "@ngrx/store";
import {getCategoryById} from "../store/categories.selectors";
import {Observable} from "rxjs";
import {Category} from "../../../../model/category";

@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.scss']
})
export class CategoryDetailsComponent implements OnInit {

  categoryId: number;
  category: Category;

  constructor(private activeRoute: ActivatedRoute, private store: State<CategoriesState>) {
    this.categoryId = this.activeRoute.snapshot.params['id']
  }

  ngOnInit() {
    this.store.pipe(select(getCategoryById, {id: this.categoryId}))
      .subscribe((result: Category) => this.category = result);
  }
}
