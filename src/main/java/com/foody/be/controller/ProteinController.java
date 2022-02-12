package com.foody.be.controller;

import com.foody.be.model.Protein;
import com.foody.be.repository.ProteinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/protein")
public class ProteinController {

    @Autowired
    ProteinRepository proteinRepository;

    @GetMapping("/list")
    //@Transactional
    public List<Protein> list(){
        List<Protein> list = proteinRepository.findAll();
        return list;
    }

    @GetMapping("/{id}")
    public Protein get(@PathVariable Long id) {
        Protein protein = proteinRepository.findById(id).get();

        return protein;
    }

    @PostMapping("")
    public Protein insert(@RequestBody Protein ch){
        Protein saved = proteinRepository.save(ch);
        return saved;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Protein> update(
            @PathVariable Long id,
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
    public Map<String, Boolean> delete(@PathVariable Long id){
        Protein protein = proteinRepository.findById(id).get();

        proteinRepository.delete(protein);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
