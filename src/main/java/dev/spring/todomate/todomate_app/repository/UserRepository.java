package dev.spring.todomate.todomate_app.repository;

import dev.spring.todomate.todomate_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
