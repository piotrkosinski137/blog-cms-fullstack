import {Post} from "./post";

export interface Category {
  id: number;
  title: string;
  dateAdded: Date;
  posts: Post[];
}
