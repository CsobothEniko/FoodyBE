package com.foody.be.repository.plan;

import com.foody.be.model.plan.Dinner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DinnerRepository extends JpaRepository<Dinner, Integer> {
}
