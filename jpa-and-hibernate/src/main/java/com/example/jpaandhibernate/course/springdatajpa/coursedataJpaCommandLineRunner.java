package com.example.jpaandhibernate.course.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.jpaandhibernate.course.Course;

@Component
public class coursedataJpaCommandLineRunner implements CommandLineRunner {

	@Autowired
	private courseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Course(1, "learnjava", "narayana"));
		repository.save(new Course(2, "learnpascal", "narayana"));
		repository.save(new Course(3, "learnc", "ranga"));
		repository.deleteById(2l);
		System.out.println(repository.findById(1l));
		System.out.println(repository.findById(3l));
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		System.out.println(repository.findByAuthor("ranga"));

	}

}
