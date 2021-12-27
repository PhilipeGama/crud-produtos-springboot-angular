package com.games.dto;

import com.games.entity.Producer;
import com.games.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProducerOutputDTO {

    private long id;

    private String name;



    public ProducerOutputDTO(Producer producer) {
        this.id = producer.getId();
        this.name = producer.getName();

    }

    public ProducerOutputDTO() {
    }

    public ProducerOutputDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public static List<ProducerOutputDTO> producesOutputDTO(List<Producer> producers){
        List<ProducerOutputDTO> producesOutputDTO = new ArrayList<>();
        for(Producer producer: producers){
            ProducerOutputDTO productOutputDTO = new ProducerOutputDTO(producer);
            producesOutputDTO.add(productOutputDTO);
        }
        return producesOutputDTO;
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

}
