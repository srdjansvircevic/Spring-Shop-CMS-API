import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './model/single-product.types';
import { environment } from '../../../environments/environment';


@Injectable()
export class SingleProductService {

  private getProductByIdUrl = 'pages/single-product-page';
  private apiUrl = environment.API_URL;

  constructor(private http: HttpClient) { }

  getProductById(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.apiUrl}/${this.getProductByIdUrl}/${id}`);
  }
}