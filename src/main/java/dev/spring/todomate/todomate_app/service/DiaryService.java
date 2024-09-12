package dev.spring.todomate.todomate_app.service;

import dev.spring.todomate.todomate_app.dto.DiaryRequest;
import dev.spring.todomate.todomate_app.dto.DiaryResponse;
import dev.spring.todomate.todomate_app.model.Diary;

import java.util.List;

public interface DiaryService {
    List<DiaryResponse> findAll(Long userId);
    DiaryResponse addDiary(Long userId, DiaryRequest diaryRequest);
    DiaryResponse updateDiary(Long userId, Long diaryId, DiaryRequest diaryRequest);
    DiaryResponse findById(Long userId, Long diaryId);
    Diary deleteDiary(Long userId, Long diaryId);
}
