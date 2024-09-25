import { Product } from "../../single-product/model/single-product.types";

export interface FeaturedProduct {
    id: number;
    product: Product;
    pictureUrl: string;
    description: string;
}


 