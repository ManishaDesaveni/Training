package com.example.first_rest_api.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

	@Autowired
	public UserCommandLineRunner(userRepository userrepository) {
		super();
		this.userrepository = userrepository;
	}

	private Logger logger = LoggerFactory.getLogger(getClass());

	private userRepository userrepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		userrepository.save(new UserDetails(1, "manisha", "backend developer"));
		userrepository.save(new UserDetails(2, "nithya", "frontend developer"));

		List<UserDetails> details = userrepository.findByname("nithya");

	}

}
