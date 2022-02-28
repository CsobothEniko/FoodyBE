package com.foody.be.controller;

import com.foody.be.model.Fruit;
import com.foody.be.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    FruitRepository fruitRepository;

    @GetMapping("/list")
    //@Transactional
    public List<Fruit> list(){
        List<Fruit> list = fruitRepository.findAll();
        return list;
    }

    @GetMapping("/{id}")
    public Fruit get(@PathVariable Integer id) {
        Fruit ch = fruitRepository.findById(id).get();

        return ch;
    }

    @PostMapping("")
    public Fruit insert(@RequestBody Fruit ch){
        Fruit saved = fruitRepository.save(ch);
        return saved;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruit> update(
            @PathVariable Integer id,
            @RequestBody Fruit detailsOfCh){
        Fruit fruit = fruitRepository.findById(id).get();
        fruit.setName(detailsOfCh.getName());
        fruit.setQuantity(detailsOfCh.getQuantity());
        fruit.setQuantityType(detailsOfCh.getQuantityType());
        fruit.setCalorie(detailsOfCh.getCalorie());
        fruit.setType(detailsOfCh.getType());

        final Fruit updatedCh = fruitRepository.save(fruit);
        return ResponseEntity.ok(updatedCh);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable Integer id){
        Fruit fruit = fruitRepository.findById(id).get();

        fruitRepository.delete(fruit);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/randomFruit")
    public Fruit getRandomId() {
        Random random = new Random();
        Integer randomId = random.nextInt(2) +1;
        Fruit fruit = fruitRepository.findById(randomId).get();

        return fruit;
    }

    // selection by types:
    @GetMapping("/breakfast")
    //@Transactional
    public List<Fruit> listAllByBreakfast(){
        List<Fruit> list = fruitRepository.getAllFruitByBreakfast();
        return list;
    }

    @GetMapping("/lunch")
    //@Transactional
    public List<Fruit> listAllByLunch(){
        List<Fruit> list = fruitRepository.getAllFruitByLunch();
        return list;
    }

    @GetMapping("/dinner")
    //@Transactional
    public List<Fruit> listAllByDinner(){
        List<Fruit> list = fruitRepository.getAllFruitByDinner();
        return list;
    }
}
