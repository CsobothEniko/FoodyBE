package com.foody.be.repository.plan;

import com.foody.be.model.plan.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchRepository extends JpaRepository<Lunch, Integer> {

    @Query(value="SELECT * FROM Lunch ORDER BY random() limit 1", nativeQuery = true)
    Lunch random();
}
