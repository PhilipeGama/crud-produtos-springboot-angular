package com.games.dto;

import com.games.entity.Producer;
import com.games.entity.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductOutputDTO {

    private long id;

    private String name;

    private float price;

    private Producer producer;

    private LocalDate dateManufacture;


    public ProductOutputDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.producer = product.getProducer();
        this.dateManufacture = product.getDateManufacture();
    }

    public ProductOutputDTO() {
    }

    public ProductOutputDTO(long id, String name, float price, Producer producer, LocalDate dateManufacture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.dateManufacture = dateManufacture;
    }


    public static List<ProductOutputDTO> productsOutputDTO(List<Product> listProduct){
        List<ProductOutputDTO> listProductOutputDTO = new ArrayList<>();
        for(Product product: listProduct){
            ProductOutputDTO productOutputDTO = new ProductOutputDTO(product);
            listProductOutputDTO.add(productOutputDTO);
        }
        return listProductOutputDTO;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getDateManufacture() {
        return dateManufacture;
    }

    public void setDateManufacture(LocalDate dateManufacture) {
        this.dateManufacture = dateManufacture;
    }
}
