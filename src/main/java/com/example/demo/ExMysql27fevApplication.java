package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExMysql27fevApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory
			.getLogger(ExMysql27fevApplication.class);



	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExMysql27fevApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {		
		// save 2 Projects
		List<Project> projs = new ArrayList<>();
		Project p1 = new Project("PA", "Preparation of work");
		Project p2 = new Project("PB", "Middle of the thing");
		projs.add(p1);
		projs.add(p2);
		projectRepository.save(projs);
		
		// save 2 Teams
		List<Team> teams = new ArrayList<>();
		Team t1 = new Team(p1);
		Team t2 = new Team(p2);
		teams.add(t1);
		teams.add(t2);
		teamRepository.save(teams);
		
//		// create and save 5 Users
//		List<User> users = new ArrayList<>();
//		users.add(t1.createNewUser("Rui"));
//		users.add(t1.createNewUser("Ana"));
//		users.add(t1.createNewUser("Jaime"));
//		users.add(t2.createNewUser("aa"));
//		users.add(t2.createNewUser("bbb"));
//		userRepository.save(users);
//		
		// create 1 user, and only after add him to Team 1
		User u1 = new User();
		u1.setName("Emanuel Pimba");
		u1.setTeamMembers(t1);
		userRepository.save(u1);
		
		
		// fetch all users
		for (User u : userRepository.findAll()) {
			logger.info(u.toString());
		}
	}
}
