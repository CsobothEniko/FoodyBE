package com.foody.be.controller;

import com.foody.be.dto.ChAndFat;
import com.foody.be.dto.RandomCh;
import com.foody.be.model.Ch;
//import lombok.RequiredArgsConstructor;
import com.foody.be.repository.ChRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ch")
//@RequiredArgsConstructor
public class ChController {

    @Autowired
    ChRepository chRepository;

    @GetMapping("/list")
    //@Transactional
    public List<Ch> list(){
        List<Ch> list = chRepository.findAll();
        System.out.println(list.get(0));
        return list;
    }

    @GetMapping("/getChAndFat")
    public List<ChAndFat> getChAndFat(){
        return chRepository.getChAndFat();
    }

    //
    @GetMapping("/random")
    public RandomCh randomCh(){
        return chRepository.getRandomCh();
    }

    @GetMapping("/{id}")
    public Ch get(@PathVariable Long id) {
        Ch ch = chRepository.findById(id).get();
        System.out.println("ch: " + ch);

        return ch;
    }

    @PostMapping("")
    public Ch insert(@RequestBody Ch ch){
        Ch saved = chRepository.save(ch);
        return saved;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ch> update(
            @PathVariable Long id,
            @RequestBody Ch detailsOfCh){
        Ch ch = chRepository.findById(id).get();
        ch.setName(detailsOfCh.getName());
        ch.setQuantity(detailsOfCh.getQuantity());
        ch.setQuantityType(detailsOfCh.getQuantityType());
        ch.setCalorie(detailsOfCh.getCalorie());
        ch.setType(detailsOfCh.getType());

        final Ch updatedCh = chRepository.save(ch);
        return ResponseEntity.ok(updatedCh);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable Long id){
        Ch ch = chRepository.findById(id).get();

        chRepository.delete(ch);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

