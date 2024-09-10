package dev.spring.todomate.todomate_app.repository;

import dev.spring.todomate.todomate_app.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findAllByUserId(Long userId);
    Optional<Diary> findDiaryByUserIdAndId(Long userId, Long id);
}
