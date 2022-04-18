package com.foody.be.repository.plan;

import com.foody.be.model.plan.BreakfastV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreakfastVRepository extends JpaRepository<BreakfastV, Integer> {
}
