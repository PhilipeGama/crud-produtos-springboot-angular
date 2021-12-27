package com.games.dto;

import com.games.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductOutputDTO {

    private long id;

    private String name;

    private float price;

    public ProductOutputDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public ProductOutputDTO() {
    }

    public ProductOutputDTO(long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
}
