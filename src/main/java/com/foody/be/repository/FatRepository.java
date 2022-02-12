package com.foody.be.repository;

import com.foody.be.model.Fat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatRepository extends JpaRepository<Fat, Long> {
}
