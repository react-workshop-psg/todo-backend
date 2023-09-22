package com.rest.webservices.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.rest.webservices.model.Todo;
import com.rest.webservices.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> findAll() {
        return (List<Todo>) todoRepository.findAll();
    }

    public Todo addTodo(String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo( description, targetDate, done);
        todoRepository.save(todo);
        return todo;
    }

   //Implement Todo Update service method here

    //Implement Todo Update delete method here

    public Todo findById(int id) {
        Optional<Todo> byId = todoRepository.findById(Long.valueOf(id));
        return byId.get();
    }

    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }
}