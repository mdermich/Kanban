package org.tse.tdspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.tse.tdspring.domain.Developer;
import org.tse.tdspring.service.DeveloperService;

@RestController
public class DeveloperController {

	@Autowired
	DeveloperService devService;
	
	@GetMapping("/developers")
	public List<Developer> findAllDevelopers(){
		return this.devService.findAllDevelopers();
	}
	
	@GetMapping("/developers/{id}")
	public Developer findDeveloper(@PathVariable long id) {
		return this.devService.findDeveloperById(id);
	}
}
