package org.tse.tdspring;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.tse.tdspring.dao.DeveloperRepository;
import org.tse.tdspring.dao.TaskStatusRepository;
import org.tse.tdspring.domain.Developer;
import org.tse.tdspring.domain.TaskStatus;

@Component
public class DatabaseRunner implements CommandLineRunner{
	
	@Autowired
    private DeveloperRepository developerRepository;
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// Populate Developer table
		developerRepository.save(new Developer("Manal", "DERMICH", "azerty", "manal.dermich@gmail.com", LocalDate.of(2021, 9, 1)));
		developerRepository.save(new Developer("John", "DOE", "123456", "john.doe@gmail.com", LocalDate.of(2020, 5, 16)));
		developerRepository.save(new Developer("Jane", "DOE", "mdp", "jane.doe@gmail.com", LocalDate.of(2022, 2, 6)));
		
		// Populate TaskStatus table
		taskStatusRepository.save(new TaskStatus(0L)); // TODO
		taskStatusRepository.save(new TaskStatus(1L)); // DOING
		taskStatusRepository.save(new TaskStatus(2L)); // TEST
		taskStatusRepository.save(new TaskStatus(3L)); // DONE
		
	}

}
