package com.foody.be.repository;

import com.foody.be.model.DietPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietPlanRepository extends JpaRepository<DietPlan, Integer> {
}
