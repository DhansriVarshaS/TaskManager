package com.cognizant.fse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.fse.eo.ParentTaskEO;

@Repository
public interface MasterTaskRepository extends JpaRepository<ParentTaskEO, Integer> {

}
