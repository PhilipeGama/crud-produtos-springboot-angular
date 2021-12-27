package com.games.dto;

import com.games.entity.Producer;
import com.games.entity.Product;

public class ProducerInputDTO {


    private String name;



    public ProducerInputDTO() {
    }

    public ProducerInputDTO(String name) {
        this.name = name;

    }

    public Producer toModel(){
        Producer producer = new Producer();
        producer.setName(this.name);
        return producer;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
