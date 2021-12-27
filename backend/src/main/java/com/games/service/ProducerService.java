package com.games.service;

import com.games.entity.Producer;
import com.games.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {

    @Autowired
    private ProducerRepository producerRepository;


    public List<Producer> findAll(){
        return producerRepository.findAll();
    }
}
