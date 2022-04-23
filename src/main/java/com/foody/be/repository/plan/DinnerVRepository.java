package com.foody.be.repository.plan;

import com.foody.be.model.plan.DinnerV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DinnerVRepository extends JpaRepository<DinnerV, Integer> {

    @Query(value = "select * from dinner_v order by id desc limit 7", nativeQuery = true)
    List<DinnerV> last7();
}
