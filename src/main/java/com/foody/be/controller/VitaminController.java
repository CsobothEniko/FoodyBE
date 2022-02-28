package com.foody.be.controller;

import com.foody.be.model.Vitamin;
import com.foody.be.repository.VitaminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vitamin")
public class VitaminController {

    @Autowired
    VitaminRepository vitaminRepository;

    @GetMapping("/list")
    //@Transactional
    public List<Vitamin> list(){
        List<Vitamin> list = vitaminRepository.findAll();
        return list;
    }

    @GetMapping("/{id}")
    public Vitamin get(@PathVariable Integer id) {
        Vitamin vitamin = vitaminRepository.findById(id).get();

        return vitamin;
    }

    @PostMapping("")
    public Vitamin insert(@RequestBody Vitamin vitamin){
        Vitamin saved = vitaminRepository.save(vitamin);
        return saved;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vitamin> update(
            @PathVariable Integer id,
            @RequestBody Vitamin detailsOfVitamin){
        Vitamin vitamin = vitaminRepository.findById(id).get();
        vitamin.setName(detailsOfVitamin.getName());
        vitamin.setQuantity(detailsOfVitamin.getQuantity());
        vitamin.setQuantityType(detailsOfVitamin.getQuantityType());
        vitamin.setCalorie(detailsOfVitamin.getCalorie());
        vitamin.setType(detailsOfVitamin.getType());

        final Vitamin updatedVitamin = vitaminRepository.save(vitamin);
        return ResponseEntity.ok(updatedVitamin);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable Integer id){
        Vitamin vitamin = vitaminRepository.findById(id).get();

        vitaminRepository.delete(vitamin);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
// selection by types:
    @GetMapping("/breakfast")
    //@Transactional
    public List<Vitamin> listAllByBreakfast(){
        List<Vitamin> list = vitaminRepository.getAllVitaminByBreakfast();
        return list;
    }

    @GetMapping("/lunch")
    //@Transactional
    public List<Vitamin> listAllByLunch(){
        List<Vitamin> list = vitaminRepository.getAllVitaminByLunch();
        return list;
    }

    @GetMapping("/dinner")
    //@Transactional
    public List<Vitamin> listAllByDinner(){
        List<Vitamin> list = vitaminRepository.getAllVitaminByDinner();
        return list;
    }
}
