package org.tse.tdspring;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.tse.tdspring.dao.DeveloperRepository;
import org.tse.tdspring.dao.TaskRepository;
import org.tse.tdspring.dao.TaskStatusRepository;
import org.tse.tdspring.dao.TaskTypeRepository;
import org.tse.tdspring.domain.Developer;
import org.tse.tdspring.domain.Task;
import org.tse.tdspring.domain.TaskStatus;
import org.tse.tdspring.domain.TaskType;

@Component
public class DatabaseRunner implements CommandLineRunner{
	
	@Autowired
    private DeveloperRepository developerRepository;
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private TaskTypeRepository taskTypeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// Populate Developer table
		Developer dev1 = new Developer("Manal", "DERMICH", "azerty", "manal.dermich@gmail.com", LocalDate.of(2021, 9, 1));
		developerRepository.save(dev1);
		Developer dev2 = new Developer("John", "DOE", "123456", "john.doe@gmail.com", LocalDate.of(2020, 5, 16));
		developerRepository.save(dev2);
		Developer dev3 = new Developer("Jane", "DOE", "mdp", "jane.doe@gmail.com", LocalDate.of(2022, 2, 6));
		developerRepository.save(dev3);
		
		// Populate TaskStatus table
		taskStatusRepository.save(new TaskStatus(0L)); // TO DO
		taskStatusRepository.save(new TaskStatus(1L)); // DOING
		taskStatusRepository.save(new TaskStatus(2L)); // TEST
		taskStatusRepository.save(new TaskStatus(3L)); // DONE

		// Populate TaskType table
		taskTypeRepository.save(new TaskType(0L));
		taskTypeRepository.save(new TaskType(1L));
		taskTypeRepository.save(new TaskType(2L));
		
		//Populate Task table
		Set<Developer> devs = new HashSet<>();
		devs.add(dev1);
		taskRepository.save(new Task("Tests", 5, 4, LocalDate.now(), devs, taskTypeRepository.findById(0L).orElse(null), taskStatusRepository.findById(0L).orElse(null)));
		devs = new HashSet<>();
		devs.add(dev2);
		devs.add(dev3);
		taskRepository.save(new Task("Designing architecture", 10, 11, LocalDate.now(), devs, taskTypeRepository.findById(1L).orElse(null), taskStatusRepository.findById(2L).orElse(null)));
		
	}

}
