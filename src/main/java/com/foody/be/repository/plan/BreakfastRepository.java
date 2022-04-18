package com.foody.be.repository.plan;

import com.foody.be.model.plan.Breakfast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreakfastRepository extends JpaRepository<Breakfast, Integer> {
}
