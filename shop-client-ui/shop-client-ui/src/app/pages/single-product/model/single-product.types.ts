export interface Product {
    id: number;
    quantity: number;
    description: string;
    name: string;
    price: number;
    image: string;
    relatedProducts: RelatedProduct;
  }
  
export interface RelatedProduct {
    id: number;
    productId: Product;
    relatedProducts: Product[];
  }