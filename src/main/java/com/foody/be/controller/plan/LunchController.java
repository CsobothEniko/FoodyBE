package com.foody.be.controller.plan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foody.be.model.plan.Lunch;
import com.foody.be.repository.*;
import com.foody.be.repository.plan.LunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lunch")
public class LunchController {

    @Autowired
    LunchRepository lunchRepository;

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

    public LunchController(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> random() throws JsonProcessingException {

        for(int i = 1; i < 8; i++ ){
            Lunch lunch = new Lunch();
            lunch.setChId(chRepository.randomLunch().getId());
            lunch.setPrId(proteinRepository.randomLunch().getId());
            lunch.setFatId(fatRepository.randomLunch().getId());
            lunch.setFrId(fruitRepository.randomLunch().getId());
            lunch.setVegId(vegetableRepository.randomLunch().getId());
            lunch.setVitaminId1(3);
            lunch.setVitaminId2(4);

            lunchRepository.save(lunch);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
