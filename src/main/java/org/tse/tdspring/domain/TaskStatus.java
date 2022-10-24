package org.tse.tdspring.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TaskStatus {
	
	@Id
	private long id;
	
	private String label;
	
	@OneToMany(mappedBy="status")
	private Set<Task> tasks;
	
	@OneToMany(mappedBy="sourceStatus")
	private Set<ChangeLog> changeLogsSource;
	
	@OneToMany(mappedBy="targetStatus")
	private Set<ChangeLog> changeLogsTarget;

	public TaskStatus() {
		
	}

	public TaskStatus(long id) {
		this.id = id;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Set<ChangeLog> getChangeLogsSource() {
		return changeLogsSource;
	}

	public void setChangeLogsSource(Set<ChangeLog> changeLogsSource) {
		this.changeLogsSource = changeLogsSource;
	}

	public Set<ChangeLog> getChangeLogsTarget() {
		return changeLogsTarget;
	}

	public void setChangeLogsTarget(Set<ChangeLog> changeLogsTarget) {
		this.changeLogsTarget = changeLogsTarget;
	}

}
