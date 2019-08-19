package com.cognizant.fse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.fse.eo.ParentTaskEO;
import com.cognizant.fse.repository.MasterTaskRepository;

@Service
public class MasterTaskService {
	
	@Autowired
	private MasterTaskRepository repo;
	

	public Iterable<ParentTaskEO> getAllUsers() {
		return repo.findAll();
	}
	
	

	public ParentTaskEO addNew(String task) {
		ParentTaskEO ptask = new ParentTaskEO();
		ptask.setParentTask(task);
		return repo.save(ptask);
	}
	

}
