package com.foody.be.controller.plan;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foody.be.repository.plan.DinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dinner")
public class DinnerController {

    @Autowired
    DinnerRepository dinnerRepository;

    private final ObjectMapper jsonMapper;

    public DinnerController(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }
}
