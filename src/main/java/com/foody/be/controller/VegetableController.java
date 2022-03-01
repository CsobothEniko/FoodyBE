package com.foody.be.controller;

import com.foody.be.model.Vegetable;
import com.foody.be.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    @Autowired
    VegetableRepository vegetableRepository;

    @GetMapping("/list")
    //@Transactional
    public List<Vegetable> list(){
        List<Vegetable> list = vegetableRepository.findAll();
        return list;
    }

    @GetMapping("/{id}")
    public Vegetable get(@PathVariable Integer id) {
        Vegetable vegetable = vegetableRepository.findById(id).get();

        return vegetable;
    }

    @PostMapping("")
    public Vegetable insert(@RequestBody Vegetable vegetable){
        Vegetable saved = vegetableRepository.save(vegetable);
        return saved;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vegetable> update(
            @PathVariable Integer id,
            @RequestBody Vegetable detailsOfVegetable){
        Vegetable vegetable = vegetableRepository.findById(id).get();
        vegetable.setName(detailsOfVegetable.getName());
        vegetable.setQuantity(detailsOfVegetable.getQuantity());
        vegetable.setQuantityType(detailsOfVegetable.getQuantityType());
        vegetable.setCalorie(detailsOfVegetable.getCalorie());
        vegetable.setType(detailsOfVegetable.getType());

        final Vegetable updatedVegetable = vegetableRepository.save(vegetable);
        return ResponseEntity.ok(updatedVegetable);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable Integer id){
        Vegetable vegetable = vegetableRepository.findById(id).get();

        vegetableRepository.delete(vegetable);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/random")
    public Vegetable getRandomId() {
        Random random = new Random();
        Integer randomId = random.nextInt(2) +1;
        Vegetable vegetable = vegetableRepository.findById(randomId).get();

        return vegetable;
    }

    // selection by types:
    @GetMapping("/breakfast")
    //@Transactional
    public List<Vegetable> listAllByBreakfast(){
        List<Vegetable> list = vegetableRepository.getAllVegetableByBreakfast();
        return list;
    }

    @GetMapping("/lunch")
    //@Transactional
    public List<Vegetable> listAllByLunch(){
        List<Vegetable> list = vegetableRepository.getAllVegetableByLunch();
        return list;
    }

    @GetMapping("/dinner")
    //@Transactional
    public List<Vegetable> listAllByDinner(){
        List<Vegetable> list = vegetableRepository.getAllVegetableByDinner();
        return list;
    }
}
