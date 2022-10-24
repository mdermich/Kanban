package org.tse.tdspring.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tse.tdspring.dao.TaskStatusRepository;
import org.tse.tdspring.domain.Task;

@SpringBootTest
@RunWith(SpringRunner.class)
class TaskServiceTest {
	
	@Autowired
	TaskStatusRepository taskStatRepo;
	@Autowired
	TaskService taskService;
	
	@Test
	void testFindAllTasks() {
		Collection<Task> allTasks = this.taskService.findAllTasks();
		assertEquals(2, allTasks.size());
	}
	
	@Test
	void testFindTask() {
		Task task = new Task("Debugging");
		taskService.taskRepo.save(task);
		Task resultTask = taskService.findTask(task.getId());
		assertEquals(task.getId(), resultTask.getId());
		assertEquals(task.getTitle(), resultTask.getTitle());
	}

	@Test
	void testMoveRightTask() {
		Task task = new Task();
		task.setStatus(taskStatRepo.findById(0L).orElse(null));
		task = taskService.moveRightTask(task);
		assertEquals(taskStatRepo.findById(1L).orElse(null), task.getStatus());
		task = taskService.moveRightTask(task);
		assertEquals(taskStatRepo.findById(2L).orElse(null), task.getStatus());
	}
	
	// A test to expect an exception when we try to move right a task that has a status "DONE"
	@Test
	void testMoveRightTask_expectException() {
		Task task = new Task();
		task.setStatus(taskStatRepo.findById(3L).orElse(null));
		assertThrows(IllegalStateException.class, ()-> taskService.moveRightTask(task));
	}
	
	@Test
	void testMoveLeftTask() {
		Task task = new Task();
		task.setStatus(taskStatRepo.findById(3L).orElse(null));
		task = taskService.moveLeftTask(task);
		assertEquals(taskStatRepo.findById(2L).orElse(null), task.getStatus());
		task = taskService.moveLeftTask(task);
		assertEquals(taskStatRepo.findById(1L).orElse(null), task.getStatus());
	}
	
	// A test to expect an exception when we try to move left a task that has a status "DONE"
	@Test
	void testMoveLeftTask_expectException() {
		Task task = new Task();
		task.setStatus(taskStatRepo.findById(0L).orElse(null));
		assertThrows(IllegalStateException.class, ()-> taskService.moveLeftTask(task));
	}

}
