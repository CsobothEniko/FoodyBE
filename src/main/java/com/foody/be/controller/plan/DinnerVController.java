package com.foody.be.controller.plan;

import com.foody.be.model.plan.DinnerV;
import com.foody.be.repository.plan.DinnerVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dinnerV")
public class DinnerVController {

    @Autowired
    DinnerVRepository dinnerVRepository;

    @GetMapping("")
    public List<DinnerV> list(){
        List<DinnerV> list = dinnerVRepository.findAll();
        return list;
    }

    @GetMapping("/weekly")
    public List<DinnerV> weekly(){
        List<DinnerV> list = dinnerVRepository.last7();
        return list;
    }

}
