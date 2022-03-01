package com.foody.be.controller;

import com.foody.be.model.Plan;
import com.foody.be.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    PlanRepository planRepository;

    @GetMapping("/list")
    public List<Plan> list(){
        List<Plan> list = planRepository.findAll();
        return list;
    }

    @GetMapping("/{id}")
    public Plan get(@PathVariable Integer id) {
        Plan plan = planRepository.findById(id).get();
        return plan;
    }

    @PostMapping("")
    public Plan insert(@RequestBody Plan plan){
        Plan saved = planRepository.save(plan);
        return saved;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Plan> update(
            @PathVariable Integer id,
            @RequestBody Plan details){
        Plan plan = planRepository.findById(id).get();
        plan.setChId(details.getChId());
        plan.setFatId(details.getFatId());
        plan.setPrId(details.getPrId());
        plan.setFrId(details.getFrId());
        plan.setVegId(details.getVegId());
        plan.setType(details.getType());

        final Plan updatedPlan = planRepository.save(plan);
        return ResponseEntity.ok(updatedPlan);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable Integer id){
        Plan plan = planRepository.findById(id).get();

        planRepository.delete(plan);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
