package com.cognizant.fse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.fse.eo.UserEO;

@Repository
public interface UserTabRepository extends JpaRepository<UserEO, Integer> {

}