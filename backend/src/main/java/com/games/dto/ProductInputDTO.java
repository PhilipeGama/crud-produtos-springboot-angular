package com.games.dto;

import com.games.entity.Producer;
import com.games.entity.Product;

public class ProductInputDTO {


    private String name;

    private float price;

    private Producer producer;

    public ProductInputDTO() {
    }

    public ProductInputDTO(String name, float price, Producer producer) {
        this.name = name;
        this.price = price;
        this.producer = producer;
    }

    public Product toModel(){
        Product product = new Product();
        product.setName(this.name);
        product.setPrice(this.price);
        product.setProducer(producer);
        return product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "ProductInputDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", producer=" + producer +
                '}';
    }
}
