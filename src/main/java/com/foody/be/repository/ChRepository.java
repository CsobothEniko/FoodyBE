package com.foody.be.repository;

import com.foody.be.dto.ChAndFat;
import com.foody.be.dto.RandomCh;
import com.foody.be.model.Ch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public interface ChRepository extends JpaRepository<Ch, Integer> {

    //@Query("SELECT c.name,f.name FROM Ch c left join Fat f on c.id=f.id")
    @Query("SELECT new com.foody.be.dto.ChAndFat(c.name, f.name) FROM Ch c JOIN Fat f on f.id = c.id")
    //@Query("SELECT new com.foody.be.dto.ChAndFat(c.name, c.type) FROM Ch c")
    List<ChAndFat> getChAndFat();

    //generating diet planner:
    //DietPlan getPlan();

    Random random = new Random();
    Integer randomId = random.nextInt(2) +1;

    /*@Query("SELECT new com.foody.be.dto.RandomCh(c.name, c.quantity,c.quantityType,c.calorie) FROM Ch c ")
    //       "WHERE c.type = 'breakfast' ORDER BY c.name ASC LIMIT 1")
            //"WHERE c.id = :randomId")
    RandomCh getRandomCh();*/

    //breakfast selection
    @Query("SELECT c FROM Ch c WHERE c.type='breakfast'")
    List<Ch> getAllChByBreakfast();

    //lunch selection:
    @Query("SELECT c FROM Ch c WHERE c.type='lunch'")
    List<Ch> getAllChByLunch();

    //dinner selection:
    @Query("SELECT c FROM Ch c WHERE c.type='dinner'")
    List<Ch> getAllChByDinner();

}
