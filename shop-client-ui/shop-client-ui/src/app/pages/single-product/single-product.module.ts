import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SingleProductRoutingModule } from './single-product-routing.module';
import { SingleProductComponent } from './single-product/single-product.component';
import { SingleProductService } from './single-product.service';


@NgModule({
  declarations: [SingleProductComponent],
  imports: [
    CommonModule,
    SingleProductRoutingModule,
  ],
  providers: [SingleProductService],
})
export class SingleProductModule { }
