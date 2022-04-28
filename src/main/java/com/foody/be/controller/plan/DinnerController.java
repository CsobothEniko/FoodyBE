package com.foody.be.controller.plan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foody.be.model.plan.Dinner;
import com.foody.be.repository.*;
import com.foody.be.repository.plan.DinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dinner")
public class DinnerController {

    @Autowired
    DinnerRepository dinnerRepository;

    @Autowired
    ChRepository chRepository;

    @Autowired
    FatRepository fatRepository;

    @Autowired
    ProteinRepository proteinRepository;

    @Autowired
    VegetableRepository vegetableRepository;

    @Autowired
    FruitRepository fruitRepository;

    private final ObjectMapper jsonMapper;

    public DinnerController(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> random() throws JsonProcessingException {
        for(int i = 1; i < 8; i++ ){
            Dinner dinner = new Dinner();
            dinner.setChId(chRepository.randomDinner().getId());
            dinner.setPrId(proteinRepository.randomDinner().getId());
            dinner.setFatId(fatRepository.randomDinner().getId());
            dinner.setFrId(fruitRepository.randomDinner().getId());
            dinner.setVegId(vegetableRepository.randomDinner().getId());
            dinner.setVitaminId1(5);

            dinnerRepository.save(dinner);
        }


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
