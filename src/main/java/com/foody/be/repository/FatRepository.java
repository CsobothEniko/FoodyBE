package com.foody.be.repository;

import com.foody.be.model.Fat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FatRepository extends JpaRepository<Fat, Integer> {

    //breakfast selection
    @Query("SELECT f FROM Fat f WHERE f.type='breakfast'")
    List<Fat> getAllFatByBreakfast();

    //lunch selection:
    @Query("SELECT f FROM Fat f WHERE f.type='lunch'")
    List<Fat> getAllFatByLunch();

    //dinner selection:
    @Query("SELECT f FROM Fat f WHERE f.type='dinner'")
    List<Fat> getAllFatByDinner();
}
