import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producer } from './producer.model';

@Injectable({
  providedIn: 'root'
})
export class ProducerService {

  baseUrl = "http://localhost:8080/produces";

  constructor(private http: HttpClient) { }

  readProducer(): Observable<Producer[]>{
    return this.http.get<Producer[]>(this.baseUrl);
  }

}
