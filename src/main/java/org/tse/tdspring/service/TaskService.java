package org.tse.tdspring.service;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tse.tdspring.dao.TaskRepository;
import org.tse.tdspring.dao.TaskStatusRepository;
import org.tse.tdspring.dao.TaskTypeRepository;
import org.tse.tdspring.domain.Task;
import org.tse.tdspring.domain.TaskStatus;
import org.tse.tdspring.domain.TaskType;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepo;
	@Autowired
	TaskStatusRepository taskStatusRepo;
	@Autowired
	TaskTypeRepository taskTypeRepo;
	
	public Collection<Task> findAllTasks(){
		return taskRepo.findAll();
	}
	
	public Task findTask(Long id) {
		return taskRepo.findById(id).isPresent() ? taskRepo.findById(id).get() : null;
	}
	
	public Task moveRightTask(Task task) {
		TaskStatus currentStatus = task.getStatus();
		// If current status is TODO, we change the status to DOING
		if(currentStatus.equals(this.taskStatusRepo.findById(0L).orElse(null))) {
			task.setStatus(this.taskStatusRepo.findById(1L).orElse(null));
		}
		// If current status is DOING, we change the status to TEST
		else if(currentStatus.equals(this.taskStatusRepo.findById(1L).orElse(null))) {
			task.setStatus(this.taskStatusRepo.findById(2L).orElse(null));
		}
		// If current status is TEST, we change the status to DONE
		else if(currentStatus.equals(this.taskStatusRepo.findById(2L).orElse(null))) {
			task.setStatus(this.taskStatusRepo.findById(3L).orElse(null));
		}
		// If current status is DONE, we raise an exception
		else if(currentStatus.equals(this.taskStatusRepo.findById(3L).orElse(null))) {
			throw new IllegalStateException();
		}
		return task;
	}
	
	public Task moveLeftTask(Task task) {
		TaskStatus currentStatus = task.getStatus();
		// If current status is TODO, we raise an exception
		if(currentStatus.equals(this.taskStatusRepo.findById(0L).orElse(null))) {
			throw new IllegalStateException();
		}
		// If current status is DOING, we change the status to TODO
		else if(currentStatus.equals(this.taskStatusRepo.findById(1L).orElse(null))) {
			task.setStatus(this.taskStatusRepo.findById(0L).orElse(null));
		}
		// If current status is TEST, we change the status to DOING
		else if(currentStatus.equals(this.taskStatusRepo.findById(2L).orElse(null))) {
			task.setStatus(this.taskStatusRepo.findById(1L).orElse(null));
		}
		// If current status is DONE, we change the status to TEST
		else if(currentStatus.equals(this.taskStatusRepo.findById(3L).orElse(null))) {
			task.setStatus(this.taskStatusRepo.findById(2L).orElse(null));
		}
		return task;
	}

	public Task createTask(Task task) {
		Task newTask = task;
		newTask.setCreated(LocalDate.now());
		newTask.setStatus(this.taskStatusRepo.findById(0L).orElse(null));
		return this.taskRepo.save(newTask);
	}

	public TaskStatus getTaskStatus(long idStatus){
		return this.taskStatusRepo.findById(idStatus).orElse(null);
	}

	public TaskType getTaskType(long idType){
		return this.taskTypeRepo.findById(idType).orElse(null);
	}

}
