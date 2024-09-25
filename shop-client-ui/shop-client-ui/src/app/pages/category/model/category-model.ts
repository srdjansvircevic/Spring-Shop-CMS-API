import { Product } from "../../single-product/model/single-product.types";

export interface Category {
    id: number;
    name: string;
    products: Product;
}
