package com.cognizant.fse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.fse.eo.ParentTaskEO;
import com.cognizant.fse.service.MasterTaskService;

@CrossOrigin
@Controller
@RequestMapping(path = "/parenttask")
public class MasterTaskController {

	@Autowired
	private MasterTaskService parentTaskService;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<ParentTaskEO> getAllParentTasks() {
		return parentTaskService.getAllUsers();
	}

	@PostMapping(path = "/add")
	public @ResponseBody ParentTaskEO addNew(@RequestParam String task) {
		return parentTaskService.addNew(task);
	}

}
