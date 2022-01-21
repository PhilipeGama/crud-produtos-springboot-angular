import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})



export class TestComponent implements OnInit {


  produtos: any[] = [];
  produto: any;

  constructor() {


  }

  ngOnInit(): void {
     this.produtos = [
      {
        id: 1,
        nome: 'Lapis 1'
      },
      {
        id: 2,
        nome: 'Lapis 2'
      },
      {
        id: 2,
        nome: 'Lapis 3'
      },
    ]

    this.produto = 2;

    console.log(this.produtos);
  }

}
