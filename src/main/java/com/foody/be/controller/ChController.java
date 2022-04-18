package com.foody.be.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foody.be.dto.ChAndFat;
import com.foody.be.model.Ch;
//import lombok.RequiredArgsConstructor;
import com.foody.be.repository.ChRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/ch")
public class ChController {

    @Autowired
    ChRepository chRepository;

    private final ObjectMapper jsonMapper;

    public ChController(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }


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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public Ch get(@PathVariable Integer id) {
        Ch ch = chRepository.findById(id).get();
        System.out.println("ch: " + ch);
        return ch;
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/randomId",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> getRandomId() {
        Random random = new Random();
        Integer randomId = random.nextInt(2) +1;
        Ch ch = chRepository.findById(randomId).get();
        System.out.println("ch: " + ch);

        return new ResponseEntity<>(ch.getName(),HttpStatus.OK);
    }

   @RequestMapping(value = "/randomBreakfast",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> random() throws JsonProcessingException {
        Ch random = chRepository.randomBreakfast();

        return new ResponseEntity<>(this.jsonMapper.writeValueAsString(random), HttpStatus.OK);
    }

    @PostMapping("")
    public Ch insert(@RequestBody Ch ch){
        Ch saved = chRepository.save(ch);
        return saved;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ch> update(
            @PathVariable Integer id,
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
    public Map<String, Boolean> delete(@PathVariable Integer id){
        Ch ch = chRepository.findById(id).get();

        chRepository.delete(ch);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/breakfast")
    //@Transactional
    public List<Ch> listAllByBreakfast(){
        List<Ch> list = chRepository.getAllChByBreakfast();
        return list;
    }

    @GetMapping("/lunch")
    //@Transactional
    public List<Ch> listAllByLunch(){
        List<Ch> list = chRepository.getAllChByLunch();
        return list;
    }

    @GetMapping("/dinner")
    //@Transactional
    public List<Ch> listAllByDinner(){
        List<Ch> list = chRepository.getAllChByDinner();
        return list;
    }

    //save the random items to plan table:

    //random ch breakfast szerint:
    @GetMapping("/randomBreakfast")
    public Ch getRandomBreakfast() {
        Random random = new Random();
        Integer randomId = random.nextInt(4) +1;

        boolean x = true;

        Ch ch = chRepository.findById(randomId).get();

        while(x == true) {
            if (ch.getType().equalsIgnoreCase("lunch")) {
                x = false;
                //return ch;
            } else {
                randomId = random.nextInt(4) + 1;
                ch = chRepository.findById(randomId).get();
                x = true;
            }
        }
        return ch;
    }

}

