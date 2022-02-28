package com.foody.be.controller;

import com.foody.be.model.DietPlan;
import com.foody.be.repository.DietPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/dietPlan")
public class DietPlanController {

    @Autowired
    DietPlanRepository dietPlanRepository;

    @GetMapping("/list")
    public List<DietPlan> list(){
        List<DietPlan> list = dietPlanRepository.findAll();
        return list;
    }

    @GetMapping("/{id}")
    public DietPlan get(@PathVariable Integer id) {
        DietPlan dietPlan = dietPlanRepository.findById(id).get();
        return dietPlan;
    }

    @PostMapping("")
    public DietPlan insert(@RequestBody DietPlan ch){
        DietPlan saved = dietPlanRepository.save(ch);
        return saved;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DietPlan> update(
            @PathVariable Integer id,
            @RequestBody DietPlan detailsOfDietPlan){
        DietPlan dietPlan = dietPlanRepository.findById(id).get();
        dietPlan.setBreakfastId(detailsOfDietPlan.getBreakfastId());
        dietPlan.setLunchId(detailsOfDietPlan.getLunchId());
        dietPlan.setDinnerId(detailsOfDietPlan.getDinnerId());
        dietPlan.setWeekday(detailsOfDietPlan.getWeekday());

        final DietPlan updatedDietPlan = dietPlanRepository.save(dietPlan);
        return ResponseEntity.ok(updatedDietPlan);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable Integer id){
        DietPlan dietPlan = dietPlanRepository.findById(id).get();

        dietPlanRepository.delete(dietPlan);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
