import { Component, OnInit } from '@angular/core';
import { Product } from '../product.model';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-read',
  templateUrl: './product-read.component.html',
  styleUrls: ['./product-read.component.scss']
})
export class ProductReadComponent implements OnInit {

  constructor(private productService: ProductService) { }

  products: Product[] = [];
  displayedColumns =  ['id', 'name', 'price', 'action'];

  ngOnInit(): void {
    this.readProduct();
  }


  readProduct(): void {
    this.productService.readProduct().subscribe(products => {
      this.products = products;
    });
  }
}
