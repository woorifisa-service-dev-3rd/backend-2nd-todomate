package dev.spring.todomate.todomate_app.service;


import dev.spring.todomate.todomate_app.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
  Optional<User> findByUsername(String username);
}
