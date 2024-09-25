import { FeaturedProduct } from "./featured-product-model";
import { Category } from "../../category/model/category-model";

export interface Home {
    featuredProducts: FeaturedProduct[];
    categories: Category[];
}
  