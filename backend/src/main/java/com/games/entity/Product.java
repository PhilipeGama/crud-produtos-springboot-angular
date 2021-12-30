package com.games.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private float price;

    @ManyToOne
    private Producer producer;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateManufacture;

    public Product() {
    }

    public Product(long id, String name, float price, Producer producer, LocalDate dateManufacture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.dateManufacture = dateManufacture;
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
