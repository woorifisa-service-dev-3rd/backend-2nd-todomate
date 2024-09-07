package dev.spring.todomate.todomate_app.service;

import dev.spring.todomate.todomate_app.model.Diary;
import dev.spring.todomate.todomate_app.model.User;
import dev.spring.todomate.todomate_app.repository.DiaryRepository;
import dev.spring.todomate.todomate_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

    @Override
    public List<Diary> findAll(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        List<Diary> diaries = diaryRepository.findAllByUserId(user.getId());
        return diaries;
    }

    @Override
    public Diary addDiary(Long userId, Diary diary) {
        User user = userRepository.findById(userId).orElseThrow();
        Diary newDiary = Diary.builder()
                .title(diary.getTitle())
                .content(diary.getContent())
                .date(LocalDate.now())
                .user(user)
                .build();
        diaryRepository.save(newDiary);
        return newDiary;
    }

    @Override
    public Diary updateDiary(Long userId, Long diaryId, Diary updatedDiary) {
        User user = userRepository.findById(userId).orElseThrow();
        Diary diary = diaryRepository.findById(diaryId).orElseThrow();
        diary.updateDiary(updatedDiary);
        return diary;
    }

    @Override
    public Diary findById(Long diaryId) {
        return diaryRepository.findById(diaryId).orElseThrow();
    }

    @Override
    public void deleteDiary(Long userId, Long diaryId) {
        User user = userRepository.findById(userId).orElseThrow();
        Diary foundDiary = diaryRepository.findDiaryByUserIdAndId(user.getId(), diaryId).orElseThrow();
        diaryRepository.deleteById(foundDiary.getId());
    }
}
