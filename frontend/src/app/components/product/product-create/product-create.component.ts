import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';
import { Product } from '../product.model';
import { Producer } from '../producer.model';
import { ProducerService } from '../producer.service';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.scss']
})
export class ProductCreateComponent implements OnInit {

  product: Product = {
    name: '',
    dateManufacture: new Date("2021-01-01")
  }

  producers: Producer[] = []

 

  constructor(private productService: ProductService, private producerService: ProducerService, private router: Router) { }

  ngOnInit(): void {
    this.getProducer();
  }

  createProduct(): void {
    this.productService.createProduct(this.product).subscribe(() => {
      this.productService.showMessage("Produto cadastrado com sucesso!");
      this.router.navigate(['/products']);
    });
  }

  cancel() {
    this.router.navigate(['/products']);
  }

  getProducer(): void {
    this.producerService.readProducer().subscribe(producers => {
      this.producers = producers;
    })
  }

}
