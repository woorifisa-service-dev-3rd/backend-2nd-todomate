package dev.spring.todomate.todomate_app.repository;

import dev.spring.todomate.todomate_app.model.Diary;
import dev.spring.todomate.todomate_app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findAllByUserId(Long userId);
    Optional<Diary> findDiaryByUserIdAndId(Long userId, Long id);
}
