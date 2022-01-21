import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../product.model';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-view',
  templateUrl: './product-view.component.html',
  styleUrls: ['./product-view.component.scss']
})
export class ProductViewComponent implements OnInit {

  product: Product = {
    name: ''
  }

  producer_name: string = '';

  constructor(private productService: ProductService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.readProduct();
    
  }

  readProduct(): void {
    const id = this.route.snapshot.paramMap.get("id");
    this.productService.readById(id).subscribe(product => {
      this.product = product;
      console.log(product.dateManufacture)
      this.product.producer! ? this.producer_name=this.product.producer.name : this.producer_name='Sem Fabricante';
    })
  
    
  }

  deleteProduct(): void {
    this.productService.deleteProduct(this.product.id).subscribe(() => {
      this.productService.showMessage("Produto deletado com sucesso!");
      this.router.navigate(['/products']);
    })
  }

  cancel(): void {
    this.router.navigate(['/products']);
  }


}
