package com.games.dto;

import com.games.entity.Product;

public class ProductInputDTO {


    private String name;

    private float price;

    public ProductInputDTO() {
    }

    public ProductInputDTO(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public Product toModel(){
        Product product = new Product();
        product.setName(this.name);
        product.setPrice(this.price);
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

    @Override
    public String toString() {
        return "ProductInputDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
