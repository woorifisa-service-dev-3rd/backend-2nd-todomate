package dev.spring.todomate.todomate_app.service;

import dev.spring.todomate.todomate_app.dto.DiaryRequest;
import dev.spring.todomate.todomate_app.dto.DiaryResponse;
import dev.spring.todomate.todomate_app.model.Diary;
import dev.spring.todomate.todomate_app.model.User;
import dev.spring.todomate.todomate_app.repository.DiaryRepository;
import dev.spring.todomate.todomate_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

    @Override
    public List<DiaryResponse> findAll(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException(userId + "에 해당하는 userId가 존재하지 않습니다."));
        List<Diary> diaries = diaryRepository.findAllByUserId(user.getId());
        List<DiaryResponse> diaryResponses = diaries.stream().map(DiaryResponse::from)
                .collect(Collectors.toList());
        return diaryResponses;
    }


    @Override
    public DiaryResponse addDiary(Long userId, DiaryRequest diaryRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException(userId + "에 해당하는 userId가 존재하지 않습니다."));
        Diary diary = Diary.from(diaryRequest, user);
        Diary savedDiary = diaryRepository.save(diary);
        DiaryResponse diaryResponse = DiaryResponse.from(savedDiary);
        return diaryResponse;
    }

    @Override
    public DiaryResponse updateDiary(Long userId, Long diaryId, DiaryRequest diaryRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException(userId + "에 해당하는 userId가 존재하지 않습니다."));
        Diary diary = diaryRepository.findById(diaryId).orElseThrow(() -> new RuntimeException(diaryId + "에 해당하는 diaryId가 존재하지 않습니다."));
        diary.updateDiary(diaryRequest);
        DiaryResponse diaryResponse = DiaryResponse.from(diary);
        return diaryResponse;
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
