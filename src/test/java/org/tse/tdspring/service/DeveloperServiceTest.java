package org.tse.tdspring.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tse.tdspring.domain.Developer;

@SpringBootTest
@RunWith(SpringRunner.class)
class DeveloperServiceTest {
	
	@Autowired
	DeveloperService devService;

	@Test
	void testFindAllDevelopers() {
		List<Developer> allDevs = this.devService.findAllDevelopers();
		assertEquals(3, allDevs.size());
	}

}
