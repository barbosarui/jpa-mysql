package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;
	
	@ManyToOne
    @JoinColumn(name = "team_id")
	private Team teamMembers;
	
	public User() {
	}

//	public User(String name) {
//		this.setName(name);
//	}
	
	public User(String name, Team teamMembers) {
		this.setName(name);
		this.teamMembers = teamMembers;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Team getTeamMembers() {
		return this.teamMembers;
	}
	
	public void setTeamMembers(Team tM) {
		this.teamMembers = tM;
	}

	@Override
	public String toString() {
		return "User [uId=" + id + ", name=" + name + "]";
	}
	
}
