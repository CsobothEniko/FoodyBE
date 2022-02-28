package com.foody.be.repository;

import com.foody.be.model.Vitamin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VitaminRepository extends JpaRepository<Vitamin, Integer> {

    //breakfast selection
    @Query("SELECT v FROM Vitamin v WHERE v.type='breakfast'")
    List<Vitamin> getAllVitaminByBreakfast();

    //lunch selection:
    @Query("SELECT v FROM Vitamin v WHERE v.type='lunch'")
    List<Vitamin> getAllVitaminByLunch();

    //dinner selection:
    @Query("SELECT v FROM Vitamin v WHERE v.type='dinner'")
    List<Vitamin> getAllVitaminByDinner();
}
