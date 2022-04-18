package com.foody.be.repository.plan;

import com.foody.be.model.plan.LunchV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchVRepository extends JpaRepository<LunchV, Integer> {
}
