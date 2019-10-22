import {Category} from "./category";

export interface Post {
  id: number;
  title: string;
  imageName: string;
  article: string;
  localDateAdded: Date;
  category: Category;
}
