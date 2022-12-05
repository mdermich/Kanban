package org.tse.tdspring.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Task {

	@Id
	@GeneratedValue
	private long id;

	@NotNull(message = "Title can't be null")
	@NotBlank(message = "Title can't be the empty string")
	private String title;

	@NotNull(message = "Number of hours forecast can't be null")
	@Min(value = 0, message = "Number of hours forecast can't be negative")
	private int nbHoursForecast;

	@NotNull(message = "Number of hours real can't be null")
	@Min(value = 0, message = "Number of hours real can't be negative")
	private int nbHoursReal;

	@NotNull(message = "Date of creation real can't be null")
	private LocalDate created;

	@NotNull(message = "Developers can't be null")
	@NotEmpty(message = "A task must at least have one developer")
	@JsonIgnoreProperties("tasks")
	@ManyToMany
	private Set<Developer> developers;

	@NotNull(message = "A task must have a type")
	@ManyToOne
	private TaskType type;

	@NotNull(message = "A task must have a status")
	@ManyToOne
	private TaskStatus status;
	
	@OneToMany(mappedBy="task")
	private Set<ChangeLog> changeLogs; 

	public Task() {
		
	}

	public Task(String title) {
		this.title = title;
	}

	public Task(String title, int nbHoursForecast, int nbHoursReal, LocalDate created, Set<Developer> developers, TaskType type, TaskStatus status) {
		this.id = id;
		this.title = title;
		this.nbHoursForecast = nbHoursForecast;
		this.nbHoursReal = nbHoursReal;
		this.created = created;
		this.developers = developers;
		this.type = type;
		this.status = status;
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
