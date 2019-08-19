package com.cognizant.fse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.fse.eo.UserEO;
import com.cognizant.fse.service.UserTabService;


@CrossOrigin
@Controller   
@RequestMapping(path="/user")
public class UserTabController {
	
	@Autowired 
	private UserTabService userService;

	@PostMapping(path="/add")
	public @ResponseBody UserEO addNewUser (@RequestBody UserEO user) {

		return userService.addNewUser(user);
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<UserEO> getAllUsers() {
		return userService.findAll();
	}
	
	@PutMapping(path="/update")
	public @ResponseBody UserEO updateUser(@RequestBody UserEO user){

		return userService.updateUser(user);
	}
	
	/*@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteUser(@PathVariable("id") Integer id){
	     userRepository.delete(id);
	     return "return";
		
	} */
}

