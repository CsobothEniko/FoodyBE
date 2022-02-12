package com.foody.be.controller;

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
        return list;
    }

    @GetMapping("/{id}")
    public Ch get(@PathVariable Long id) {
        Ch ch = chRepository.findById(id).get();

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
/*
    @DeleteMapping("/delete-employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId)
    {
     EmployeeEntity employee = employeeRepository.findById(employeeId).get();

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
 */
