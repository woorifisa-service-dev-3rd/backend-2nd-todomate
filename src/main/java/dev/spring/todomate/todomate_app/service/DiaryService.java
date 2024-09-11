package dev.spring.todomate.todomate_app.service;

import dev.spring.todomate.todomate_app.dto.DiaryRequest;
import dev.spring.todomate.todomate_app.dto.DiaryResponse;
import dev.spring.todomate.todomate_app.model.Diary;

import java.util.List;

public interface DiaryService {
    List<DiaryResponse> findAll(Long userId);
    DiaryResponse addDiary(Long userId, DiaryRequest diaryRequest);
    Diary updateDiary(Long userId, Long diaryId, Diary updatedDiary);
    Diary findById(Long diaryId);
    void deleteDiary(Long userId, Long diaryId);
}
