import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Producer } from '../producer.model';
import { ProducerService } from '../producer.service';
import { Product } from '../product.model';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.scss']
})
export class ProductUpdateComponent implements OnInit {

  product: Product =
    {
      name: '',
    };

  producers: Producer[] = []

  selectedProducer: Number | undefined;

  constructor(private productService: ProductService, private producerService: ProducerService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.readById();
    this.getProducers();
  }



  updateProduct(): void {
    this.productService.updateProduct(this.product).subscribe(() => {

      this.productService.showMessage('Produto atualizado com sucesso!');
      this.router.navigate(['/products']);
    })

  }

  cancel(): void {
  

    this.router.navigate(['/products']);
    console.log(this.product.producer);
  
  }

  readById(): void {
    const id = this.route.snapshot.paramMap.get('id');

    this.productService.readById(id).subscribe(product => {
      this.product = product;
      console.log(product);
      
      this.selectedProducer = this.product.producer?.id;
      
    });
  }

  getProducers(): void {
    this.producerService.readProducer().subscribe(producers => {
      this.producers = producers;
    });

  }
}
