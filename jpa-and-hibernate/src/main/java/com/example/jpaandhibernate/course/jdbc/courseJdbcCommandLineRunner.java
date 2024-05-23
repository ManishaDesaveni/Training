/*
 * package com.example.jpaandhibernate.course.jdbc;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.CommandLineRunner; import
 * org.springframework.stereotype.Component;
 * 
 * import com.example.jpaandhibernate.course.Course;
 * 
 * @Component public class courseJdbcCommandLineRunner implements
 * CommandLineRunner {
 * 
 * @Autowired private jdbcCourseRepository repository;
 * 
 * @Override public void run(String... args) throws Exception { // TODO
 * Auto-generated method stub repository.insert(new Course(1, "learnpascal",
 * "narayana")); repository.insert(new Course(2, "learnpascal", "narayana"));
 * repository.insert(new Course(3, "learnpascal", "narayana"));
 * repository.delete(2); System.out.println(repository.findById(1));
 * System.out.println(repository.findById(3));
 * 
 * }
 * 
 * }
 */
