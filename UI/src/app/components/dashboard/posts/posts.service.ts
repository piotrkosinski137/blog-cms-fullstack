import { Injectable } from '@angular/core';
import {PageRequest} from "../../../model/page.request";
import {HttpClient, HttpParams} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PostsService {

  constructor(private http: HttpClient) { }

  loadPostsPage(pageRequest: PageRequest) {
    let params = new HttpParams();
    params = params.append('page', '' + pageRequest.page);
    params = params.append('size', '' + pageRequest.size);

    return this.http.get('api/posts', {params: params});
  }

  deletePost(id: number) {
    let params = new HttpParams();
    params = params.append('id', '' + id);
    return this.http.delete('api/posts', {params: params})
  }
}
