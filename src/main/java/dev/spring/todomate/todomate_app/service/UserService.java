package dev.spring.todomate.todomate_app.service;

import dev.spring.todomate.todomate_app.model.User;

public interface UserService {
    User findById(Long id);
}
