package com.foody.be.repository;

import com.foody.be.model.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Integer> {

    //breakfast selection
    @Query("SELECT v FROM Vegetable v WHERE v.type='breakfast'")
    List<Vegetable> getAllVegetableByBreakfast();

    //lunch selection:
    @Query("SELECT v FROM Vegetable v WHERE v.type='lunch'")
    List<Vegetable> getAllVegetableByLunch();

    //dinner selection:
    @Query("SELECT v FROM Vegetable v WHERE v.type='dinner'")
    List<Vegetable> getAllVegetableByDinner();

    @Query(value="SELECT * FROM Vegetable WHERE type='breakfast' ORDER BY random() limit 1", nativeQuery = true)
    Vegetable randomBreakfast();

    @Query(value="SELECT * FROM Vegetable WHERE type='lunch' ORDER BY random() limit 1", nativeQuery = true)
    Vegetable randomLunch();

    @Query(value="SELECT * FROM Vegetable WHERE type='dinner' ORDER BY random() limit 1", nativeQuery = true)
    Vegetable randomDinner();
}
