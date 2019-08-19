package com.cognizant.fse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.fse.eo.TaskEO;

@Repository
public interface SubTaskRepository extends JpaRepository<TaskEO, Integer> {
}
