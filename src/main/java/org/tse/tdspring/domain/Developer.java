package org.tse.tdspring.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Developer {

	@Id
	@GeneratedValue
	private long id;
	
	private String firstname;
	
	private String lastname;
	
	// To hide password from GET response
	@JsonIgnore
	private String password;
	
	private String email;
	
	private LocalDate startContract;
	
	@ManyToMany(mappedBy="developers")
	private Set<Task> tasks;
	
	public Developer() {
		
	}

	public Developer(String firstname, String lastname, String password, String email, LocalDate startContract) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.startContract = startContract;
		this.tasks = new HashSet<>();
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getStartContract() {
		return startContract;
	}

	public void setStartContract(LocalDate startContract) {
		this.startContract = startContract;
	}
	
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
}
