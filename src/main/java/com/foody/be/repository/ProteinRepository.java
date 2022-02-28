package com.foody.be.repository;

import com.foody.be.model.Protein;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProteinRepository extends JpaRepository<Protein, Integer> {

    //breakfast selection
    @Query("SELECT p FROM Protein p WHERE p.type='breakfast'")
    List<Protein> getAllProteinByBreakfast();

    //lunch selection:
    @Query("SELECT p FROM Protein p WHERE p.type='lunch'")
    List<Protein> getAllProteinByLunch();

    //dinner selection:
    @Query("SELECT p FROM Protein p WHERE p.type='dinner'")
    List<Protein> getAllProteinByDinner();
}
