package com.rest.webservices.controller;

import java.util.List;

import com.rest.webservices.model.Todo;
import com.rest.webservices.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<Todo> retrieveTodos() {
        return todoService.findAll();
    }

    @GetMapping("/todos/{id}")
    public Todo retrieveTodo(@PathVariable int id) {
        return todoService.findById(id);
    }

    //Implement Delete Todo API here

    //Implement Update Todo API here

    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.addTodo( todo.getDescription(),
                todo.getTargetDate(), todo.isDone());
        return createdTodo;
    }

}
