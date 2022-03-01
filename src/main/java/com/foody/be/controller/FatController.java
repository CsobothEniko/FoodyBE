package com.foody.be.controller;

import com.foody.be.model.Fat;
import com.foody.be.repository.FatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/fat")
public class FatController {

    @Autowired
    FatRepository fatRepository;

    @GetMapping("/list")
    //@Transactional
    public List<Fat> list(){
        List<Fat> list = fatRepository.findAll();
        return list;
    }

    @GetMapping("/{id}")
    public Fat get(@PathVariable Integer id) {
        Fat ch = fatRepository.findById(id).get();

        return ch;
    }

    @PostMapping("")
    public Fat insert(@RequestBody Fat ch){
        Fat saved = fatRepository.save(ch);
        return saved;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fat> update(
            @PathVariable Integer id,
            @RequestBody Fat detailsOfCh){
        Fat fat = fatRepository.findById(id).get();
        fat.setName(detailsOfCh.getName());
        fat.setQuantity(detailsOfCh.getQuantity());
        fat.setQuantityType(detailsOfCh.getQuantityType());
        fat.setCalorie(detailsOfCh.getCalorie());
        fat.setType(detailsOfCh.getType());

        final Fat updatedCh = fatRepository.save(fat);
        return ResponseEntity.ok(updatedCh);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable Integer id){
        Fat fat = fatRepository.findById(id).get();

        fatRepository.delete(fat);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/random")
    public Fat getRandomId() {
        Random random = new Random();
        Integer randomId = random.nextInt(2) +1;
        Fat fat = fatRepository.findById(randomId).get();

        return fat;
    }

    // selection by types:
    @GetMapping("/breakfast")
    //@Transactional
    public List<Fat> listAllByBreakfast(){
        List<Fat> list = fatRepository.getAllFatByBreakfast();
        return list;
    }

    @GetMapping("/lunch")
    //@Transactional
    public List<Fat> listAllByLunch(){
        List<Fat> list = fatRepository.getAllFatByLunch();
        return list;
    }

    @GetMapping("/dinner")
    //@Transactional
    public List<Fat> listAllByDinner(){
        List<Fat> list = fatRepository.getAllFatByDinner();
        return list;
    }
}
