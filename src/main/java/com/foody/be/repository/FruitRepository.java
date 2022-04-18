package com.foody.be.repository;

import com.foody.be.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer> {

    //breakfast selection
    @Query("SELECT f FROM Fruit f WHERE f.type='breakfast'")
    List<Fruit> getAllFruitByBreakfast();

    //lunch selection:
    @Query("SELECT f FROM Fruit f WHERE f.type='lunch'")
    List<Fruit> getAllFruitByLunch();

    //dinner selection:
    @Query("SELECT f FROM Fruit f WHERE f.type='dinner'")
    List<Fruit> getAllFruitByDinner();

    @Query(value="SELECT * FROM Fruit WHERE type='breakfast' ORDER BY random() limit 1", nativeQuery = true)
    Fruit randomBreakfast();

    @Query(value="SELECT * FROM Fruit WHERE type='lunch' ORDER BY random() limit 1", nativeQuery = true)
    Fruit randomLunch();

    @Query(value="SELECT * FROM Fruit WHERE type='dinner' ORDER BY random() limit 1", nativeQuery = true)
    Fruit randomDinner();
}
