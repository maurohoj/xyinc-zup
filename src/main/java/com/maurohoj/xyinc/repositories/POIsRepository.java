package com.maurohoj.xyinc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maurohoj.xyinc.domain.POIs;

@Repository
public interface POIsRepository extends JpaRepository<POIs, Integer>{

}
