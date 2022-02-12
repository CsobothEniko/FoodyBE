package com.foody.be.controller;

import com.foody.be.model.Fruit;
import com.foody.be.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Fruit get(@PathVariable Long id) {
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
            @PathVariable Long id,
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
    public Map<String, Boolean> delete(@PathVariable Long id){
        Fruit fruit = fruitRepository.findById(id).get();

        fruitRepository.delete(fruit);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
