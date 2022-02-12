package com.foody.be.repository;

import com.foody.be.model.Ch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChRepository extends JpaRepository<Ch, Long> {

}
