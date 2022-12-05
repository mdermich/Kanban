package org.tse.tdspring.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tse.tdspring.TaskAction;
import org.tse.tdspring.domain.Task;
import org.tse.tdspring.service.TaskService;

import javax.validation.Valid;

@RestController
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/tasks")
	public Collection<Task> findAllTasks(){
		return this.taskService.findAllTasks();
	}
	
	@PostMapping("/tasks")
	public Task createTask(@Valid @RequestBody Task task) {
		return this.taskService.createTask(task);
	}
	
	@PatchMapping("/tasks/{id}")
	public Task moveTask(@RequestBody TaskAction action, @PathVariable long id) {
		Task task = this.taskService.findTask(id);
		switch(action.getAction()) {
			case "MoveLeft":
				task = this.taskService.moveLeftTask(task);
				break;
			case "MoveRight":
				task = this.taskService.moveRightTask(task);
				break;
			default:
				throw new IllegalArgumentException();
		}
		return task;
	}

}
