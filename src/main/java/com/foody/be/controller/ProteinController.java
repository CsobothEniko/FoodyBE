package com.foody.be.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foody.be.model.Protein;
import com.foody.be.repository.ProteinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/protein")
public class ProteinController {

    @Autowired
    ProteinRepository proteinRepository;

    private final ObjectMapper jsonMapper;

    public ProteinController(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/list")
    //@Transactional
    public List<Protein> list(){
        List<Protein> list = proteinRepository.findAll();
        return list;
    }

    @GetMapping("/{id}")
    public Protein get(@PathVariable Integer id) {
        Protein protein = proteinRepository.findById(id).get();

        return protein;
    }

    /*@PostMapping("")
    public Protein insert(@RequestBody Protein ch){
        Protein saved = proteinRepository.save(ch);
        return saved;
    }*/

    @PostMapping("")
    public ResponseEntity<String>  insert(@RequestBody Protein ch) throws JsonProcessingException {
        Protein saved = proteinRepository.save(ch);
        return new ResponseEntity<>(this.jsonMapper.writeValueAsString(saved), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Protein> update(
            @PathVariable Integer id,
            @RequestBody Protein detailsOfCh){
        Protein protein = proteinRepository.findById(id).get();
        protein.setName(detailsOfCh.getName());
        protein.setQuantity(detailsOfCh.getQuantity());
        protein.setQuantityType(detailsOfCh.getQuantityType());
        protein.setCalorie(detailsOfCh.getCalorie());
        protein.setType(detailsOfCh.getType());

        final Protein updatedCh = proteinRepository.save(protein);
        return ResponseEntity.ok(updatedCh);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable Integer id){
        Protein protein = proteinRepository.findById(id).get();

        proteinRepository.delete(protein);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/random")
    public Protein getRandomId() {
        Random random = new Random();
        Integer randomId = random.nextInt(2) +1;
        Protein protein = proteinRepository.findById(randomId).get();

        return protein;
    }

    // selection by types:
    @GetMapping("/breakfast")
    //@Transactional
    public List<Protein> listAllByBreakfast(){
        List<Protein> list = proteinRepository.getAllProteinByBreakfast();
        return list;
    }

    @GetMapping("/lunch")
    //@Transactional
    public List<Protein> listAllByLunch(){
        List<Protein> list = proteinRepository.getAllProteinByLunch();
        return list;
    }

    @GetMapping("/dinner")
    //@Transactional
    public List<Protein> listAllByDinner(){
        List<Protein> list = proteinRepository.getAllProteinByDinner();
        return list;
    }
}
