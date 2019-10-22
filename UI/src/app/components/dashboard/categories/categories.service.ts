import {Injectable} from '@angular/core';
import {PageRequest} from "../../../model/page.request";
import {HttpClient, HttpParams} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CategoriesService {

  constructor(private http: HttpClient) {
  }

  loadCategoriesPage(pageRequest: PageRequest) {
    let params = new HttpParams();
    params = params.append('page', '' + pageRequest.page);
    params = params.append('size', '' + pageRequest.size);

    return this.http.get('api/categories', {params: params});
  }
}
