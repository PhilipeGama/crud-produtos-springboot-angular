package com.games.controller;

import com.games.dto.ProducerOutputDTO;
import com.games.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produces")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping
    public List<ProducerOutputDTO> getProduces(){
//        List<Producer> producers = producerService.findAll();
          List<ProducerOutputDTO> producersOutputDTO = ProducerOutputDTO.producesOutputDTO(producerService.findAll());
          return  producersOutputDTO;

    }
}
