import {Component, Input, OnInit} from '@angular/core';
import {Post} from "../../../../model/post";

@Component({
  selector: 'app-editpost',
  templateUrl: './edit-post.component.html',
  styleUrls: ['./edit-post.component.scss']
})
export class EditPostComponent implements OnInit {

  @Input()
  editedPost: Post;

  constructor() { }

  ngOnInit() {
  }

}
