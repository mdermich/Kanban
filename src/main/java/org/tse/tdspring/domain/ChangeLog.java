package org.tse.tdspring.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ChangeLog {

	@Id
	@GeneratedValue
	private long id;
	
	private LocalDate occured;
	
	@ManyToOne
	private Task task;
	
	@ManyToOne
	private TaskStatus sourceStatus;
	
	@ManyToOne
	private TaskStatus targetStatus;

	public ChangeLog() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getOccured() {
		return occured;
	}

	public void setOccured(LocalDate occured) {
		this.occured = occured;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TaskStatus getSourceStatus() {
		return sourceStatus;
	}

	public void setSourceStatus(TaskStatus sourceStatus) {
		this.sourceStatus = sourceStatus;
	}

	public TaskStatus getTargetStatus() {
		return targetStatus;
	}

	public void setTargetStatus(TaskStatus targetStatus) {
		this.targetStatus = targetStatus;
	}
	
	
}
