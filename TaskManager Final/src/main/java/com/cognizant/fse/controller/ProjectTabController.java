package com.cognizant.fse.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.fse.dto.ProjectDTO;
import com.cognizant.fse.service.ProjectTabService;
@CrossOrigin
@RestController
@RequestMapping(path="/project")
public class ProjectTabController {

	@Autowired
	private ProjectTabService projectService;
	
	@PostMapping()
	public @ResponseBody ProjectDTO addProject(@RequestBody ProjectDTO p){
		return projectService.addProject(p);
	}
	
	@PutMapping
	public @ResponseBody ProjectDTO updateProject(@RequestBody ProjectDTO p){
		
	return projectService.updateProject(p);
	}
	
	@GetMapping(path="/all")
	public @ResponseBody List<ProjectDTO> getAllProject() {
		
		return projectService.getAllProject();
	}
	
	
	
}
