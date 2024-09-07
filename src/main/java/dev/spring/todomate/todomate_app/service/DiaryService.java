package dev.spring.todomate.todomate_app.service;

import dev.spring.todomate.todomate_app.model.Diary;

import java.util.List;

public interface DiaryService {
    List<Diary> findAll(Long userId);
    Diary addDiary(Long userId, Diary diary);
    Diary updateDiary(Long userId, Long diaryId, Diary updatedDiary);
    Diary findById(Long diaryId);
    void deleteDiary(Long userId, Long diaryId);
}
