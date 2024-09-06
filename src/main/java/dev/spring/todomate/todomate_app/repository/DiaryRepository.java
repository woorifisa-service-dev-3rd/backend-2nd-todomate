package dev.spring.todomate.todomate_app.repository;

import dev.spring.todomate.todomate_app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Todo, Long> {
}
