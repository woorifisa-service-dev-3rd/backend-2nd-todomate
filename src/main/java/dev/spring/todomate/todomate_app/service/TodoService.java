package dev.spring.todomate.todomate_app.service;

import dev.spring.todomate.todomate_app.model.Todo;

import java.util.List;

public interface TodoService {
    void addTodoDetails(Todo todo);
    List<Todo> getAllTodos();
}
