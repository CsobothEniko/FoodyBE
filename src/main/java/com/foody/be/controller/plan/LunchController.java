package com.foody.be.controller.plan;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foody.be.repository.plan.LunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lunch")
public class LunchController {

    @Autowired
    LunchRepository lunchRepository;

    private final ObjectMapper jsonMapper;

    public LunchController(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }
}
