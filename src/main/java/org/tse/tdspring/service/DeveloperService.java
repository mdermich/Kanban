package org.tse.tdspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tse.tdspring.dao.DeveloperRepository;
import org.tse.tdspring.domain.Developer;

@Service
public class DeveloperService {
	
	@Autowired
	DeveloperRepository devRepo;
	
	public List<Developer> findAllDevelopers(){
		return devRepo.findAll();
	}

}
