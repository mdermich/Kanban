package org.tse.tdspring.domain;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Task {

	@Id
	@GeneratedValue
	private long id;
	
	private String title;
	
	private int nbHoursForecast;
	
	private int nbHoursReal;
	
	private LocalDate created;
	
	@ManyToMany
	private Set<Developer> developers;
	
	@ManyToOne
	private TaskType type;
	
	@ManyToOne
	private TaskStatus status;
	
	@OneToMany(mappedBy="task")
	private Set<ChangeLog> changeLogs; 

	public Task() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNbHoursForecast() {
		return nbHoursForecast;
	}

	public void setNbHoursForecast(int nbHoursForecast) {
		this.nbHoursForecast = nbHoursForecast;
	}

	public int getNbHoursReal() {
		return nbHoursReal;
	}

	public void setNbHoursReal(int nbHoursReal) {
		this.nbHoursReal = nbHoursReal;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public Set<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(Set<Developer> developers) {
		this.developers = developers;
	}

	public TaskType getType() {
		return type;
	}

	public void setType(TaskType type) {
		this.type = type;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public Set<ChangeLog> getChangeLogs() {
		return changeLogs;
	}

	public void setChangeLogs(Set<ChangeLog> changeLogs) {
		this.changeLogs = changeLogs;
	}
	
	public void addDeveloper(Developer developer) {
		this.developers.add(developer);
		developer.getTasks().add(this);
	}
}
