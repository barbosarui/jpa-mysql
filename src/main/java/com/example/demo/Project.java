package com.example.demo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Project {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String description;
		
	@OneToOne(mappedBy = "project", cascade = CascadeType.ALL)
	private Team team;

	public Project() {
	}
	
	public Project(String name, String description) {
		this.name = name;
		this.description = description;
		//this.team = new Team(this);
	}
//	
//	public Project(String name, String description, Team team) {
//		this.name = name;
//		this.description = description;
//		this.team = team;
//	}
	
	public Team getTeam() {
		return this.team;
	}
	public void setTeam(Team t) {
		this.team = t;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Project [pId=" + id + ", name=" + name + ", description="
				+ description + "]";
	}

}
