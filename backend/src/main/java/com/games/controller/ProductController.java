package com.games.controller;


import com.games.dto.ProductInputDTO;
import com.games.dto.ProductOutputDTO;
import com.games.entity.Product;

import com.games.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductOutputDTO> getProducts(){
        List<Product> products = productService.findProducts();
        List<ProductOutputDTO> productsDTO = ProductOutputDTO.productsOutputDTO(products);
        return productsDTO;
    }

    @GetMapping("/{id}")
    public ProductOutputDTO getProduct(@PathVariable(value = "id") long id){
        Optional<Product> productOptional = productService.findProductById(id);

        System.out.println(id);
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            ProductOutputDTO productOutputDTO = new ProductOutputDTO(product);
            return productOutputDTO;
        }
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product postProduct(@RequestBody ProductInputDTO productInputDTO){
        Product product = productInputDTO.toModel();
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product putProduct(@PathVariable(value = "id") long id,@RequestBody ProductInputDTO productInputDTO){
        Product product = productInputDTO.toModel();
        return productService.updateProduct(id, product);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable(value = "id")long id){
        System.out.println(id);
        productService.deleteGames(id);
    }



}
