import { Producer } from "./producer.model";

export interface Product {
    id?: number;
    name: string;
    price?: number;
    producer?: Producer;
    dateManufacture?: Date;
}