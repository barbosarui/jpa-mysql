package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToMany(mappedBy = "teamMembers", cascade = CascadeType.ALL)
	private List<User> userList;
	
	@OneToOne
	@JoinColumn(name="proj_id")
	private Project project;

	public Team() {
		
	}
	
	public Team(Project p) {
		this.userList = new ArrayList<>();
		this.project = p;
	}

	public List<User> getUserList() {
		return userList;
	}
	
	public void setUserList(List<User> list) {
		this.userList = list;
	}

	public User createNewUser(String name) {
		User newUser = new User(name, this);
		this.userList.add(newUser);
		return newUser;
	}

	@Override
	public String toString() {
		String output = "userList: [start]\n";
		for (User u : userList) {
			output = u.toString() + "\n";
		}
		return output + "[end]";
	}

}
