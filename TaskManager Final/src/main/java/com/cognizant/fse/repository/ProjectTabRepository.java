package com.cognizant.fse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.fse.eo.ProjectEO;

@Repository
public interface ProjectTabRepository extends JpaRepository<ProjectEO, Long> {

}
