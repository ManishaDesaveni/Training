package com.example.todolist.Todos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

	private Todoservice todoservice;

	public TodoController(Todoservice todoservice) {
		super();
		this.todoservice = todoservice;
	}

	@RequestMapping("todos-list")
	public String listAlltodos(ModelMap model) {
		String username = getLoggedinUsername(model);
		List<Todo> todofinal = todoservice.findByUsername(username);
		model.addAttribute("todos", todofinal);

		return "todolist";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showtodos(ModelMap model) {
		String username = getLoggedinUsername(model);
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "addtodo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String newaddtodos(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addtodo";
		}
		String username = getLoggedinUsername(model);
		todoservice.addTodo(username, todo.getDescription(), todo.getTargetdate(), false);
		return "redirect:todos-list";
	}

	@RequestMapping("todo-delete")
	public String deleteTodo(@RequestParam int id, ModelMap model) {
		todoservice.deleteById(id);
		return "redirect:todos-list";
	}

	@RequestMapping(value = "todo-update", method = RequestMethod.GET)
	public String updateTodo(@RequestParam int id, ModelMap model) {
		Todo todo = todoservice.findById(id);
		model.addAttribute("todo", todo);
		return "addtodo";
	}

	@RequestMapping(value = "todo-update", method = RequestMethod.POST)
	public String newupdatetodos(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addtodo";
		}
		String username = getLoggedinUsername(model);
		todoservice.updateTodo(todo);
		return "redirect:todos-list";
	}

	private String getLoggedinUsername(ModelMap model) {
		return (String) model.get("name");
	}

}
