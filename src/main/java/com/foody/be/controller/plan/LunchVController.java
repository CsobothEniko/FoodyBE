package com.foody.be.controller.plan;

import com.foody.be.model.plan.LunchV;
import com.foody.be.repository.plan.LunchVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lunchV")
public class LunchVController {

    @Autowired
    LunchVRepository lunchVRepository;

    @GetMapping("")
    public List<LunchV> list(){
        List<LunchV> list = lunchVRepository.findAll();
        return list;
    }

    @GetMapping("/weekly")
    public List<LunchV> weekly(){
        List<LunchV> list = lunchVRepository.last7();
        return list;
    }
}
