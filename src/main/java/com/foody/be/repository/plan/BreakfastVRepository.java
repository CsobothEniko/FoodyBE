package com.foody.be.repository.plan;

import com.foody.be.model.plan.BreakfastV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreakfastVRepository extends JpaRepository<BreakfastV, Integer> {

    @Query(value = "select * from breakfast_v order by id desc limit 7", nativeQuery = true)
    List<BreakfastV> last7();
}
