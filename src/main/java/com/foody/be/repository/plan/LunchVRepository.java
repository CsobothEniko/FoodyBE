package com.foody.be.repository.plan;

import com.foody.be.model.plan.LunchV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LunchVRepository extends JpaRepository<LunchV, Integer> {

    @Query(value = "select * from lunch_v order by id desc limit 7", nativeQuery = true)
    List<LunchV> last7();
}
