package com.foody.be.controller.plan;

import com.foody.be.model.plan.BreakfastV;
import com.foody.be.repository.plan.BreakfastVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/breakfastV")
public class BreakfastVController {

    @Autowired
    BreakfastVRepository breakfastVRepository;

    @GetMapping("")
    public List<BreakfastV> list(){
        List<BreakfastV> list = breakfastVRepository.findAll();
        return list;
    }

    @GetMapping("/weekly")
    public List<BreakfastV> weekly(){
        List<BreakfastV> list = breakfastVRepository.last7();
        return list;
    }
}
