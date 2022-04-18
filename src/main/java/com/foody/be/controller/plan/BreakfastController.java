package com.foody.be.controller.plan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foody.be.model.Ch;
import com.foody.be.model.plan.Breakfast;
import com.foody.be.repository.*;
import com.foody.be.repository.plan.BreakfastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/breakfast")
public class BreakfastController {

    @Autowired
    BreakfastRepository breakfastRepository;

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

    public BreakfastController(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> random() throws JsonProcessingException {
        Breakfast br = new Breakfast();
        br.setChId(chRepository.randomBreakfast().getId());
        br.setPrId(proteinRepository.randomBreakfast().getId());
        br.setFatId(fatRepository.randomBreakfast().getId());
        br.setFrId(fruitRepository.randomBreakfast().getId());
        br.setVegId(vegetableRepository.randomBreakfast().getId());
        br.setVitaminId1(1);
        br.setVitaminid2(2);

        breakfastRepository.save(br);

        return new ResponseEntity<>(this.jsonMapper.writeValueAsString(br), HttpStatus.OK);
    }


}
