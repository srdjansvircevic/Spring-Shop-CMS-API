import { AfterViewInit, Component, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../model/single-product.types';
import { SingleProductService } from '../single-product.service';

@Component({
  selector: 'single-product-single-product',
  templateUrl: './single-product.component.html',
  styleUrl: './single-product.component.scss'
})

export class SingleProductComponent implements OnInit, AfterViewInit, OnDestroy, OnChanges {
  productId: string | null = null;

  product: Product | null = null;
  loading: boolean = true;
  error: string | null = null;

  constructor(
    private route: ActivatedRoute,
    private singleProductService: SingleProductService
  ) {}

  ngOnChanges(changes: SimpleChanges): void {
   // alert('on changes view init');
  }

  ngAfterViewInit(): void {
   // alert('after view init');
  }

  ngOnDestroy(): void {
   // alert('on destroy view init');
  }

 ngOnInit(): void {
    this.productId = this.route.snapshot.paramMap.get('id');

    if (this.productId) {
      this.singleProductService.getProductById(+this.productId).subscribe({
        next: (data: Product) => {
          this.product = data;
          this.loading = false;
        },
        error: (err) => {
          this.error = 'Failed to load product details.';
          this.loading = false;
        }
      });
    } else {
      this.error = 'No product ID provided.';
      this.loading = false;
    }
  }
}
