package com.example.todolist.Todos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class Todoservice {
	private static List<Todo> todos = new ArrayList<>();
	private static int todocount = 0;

	static {
		todos.add(new Todo(++todocount, "python", "Learn python", LocalDate.now().plusYears(1), true));
		todos.add(new Todo(++todocount, "java", "Learn java", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todocount, "c++", "Learn c++", LocalDate.now().plusYears(3), false));
	}

	public List<Todo> findByUsername(String username) {
		Predicate<Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		List<Todo> filteredTodos = todos.stream().filter(predicate).collect(Collectors.toList());
		return filteredTodos;
	}

	public List<Todo> addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo newTodo = new Todo(++todocount, username, description, targetDate, done);
		todos.add(newTodo);
		return todos;
	}

	public void deleteById(int id) {
		Predicate<Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<Todo> predicate = todo -> todo.getId() == id;
		return todos.stream().filter(predicate).findFirst().orElse(null);
	}

	public void updateTodo(@Valid Todo updatedTodo) {
		deleteById(updatedTodo.getId());
		todos.add(updatedTodo);
	}
}
