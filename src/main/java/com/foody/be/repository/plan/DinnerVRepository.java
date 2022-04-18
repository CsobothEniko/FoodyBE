package com.foody.be.repository.plan;

import com.foody.be.model.plan.DinnerV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DinnerVRepository extends JpaRepository<DinnerV, Integer> {
}
