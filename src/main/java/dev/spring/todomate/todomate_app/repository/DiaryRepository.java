package dev.spring.todomate.todomate_app.repository;

import dev.spring.todomate.todomate_app.model.Diary;
import dev.spring.todomate.todomate_app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findAllByUserId(Long userId);
}
