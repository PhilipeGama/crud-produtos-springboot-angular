package com.games.service;

import com.games.entity.Product;
import com.games.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(long id){
        System.out.println(id);
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(long id, Product productUpdate){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            productUpdate.setId(product.get().getId());
            return productRepository.save(productUpdate);
        }
        return null;
    }


    public void deleteGames(long id){
        Optional<Product> findProduct = productRepository.findById(id);
        if(findProduct.isPresent()) {
            productRepository.delete(findProduct.get());
        }
    }
}
