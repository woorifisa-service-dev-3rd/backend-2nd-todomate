package dev.spring.todomate.todomate_app.controller;

import dev.spring.todomate.todomate_app.dto.DiaryRequest;
import dev.spring.todomate.todomate_app.dto.DiaryResponse;
import dev.spring.todomate.todomate_app.model.Diary;
import dev.spring.todomate.todomate_app.service.DiaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/diaries")
public class DiaryController {

    private final DiaryService diaryService;

    private Long getUserIdFromSession(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        return 1L;
    }

    @GetMapping("/list")
    public ResponseEntity<List<DiaryResponse>> findAll(HttpSession session) {
        Long userId = getUserIdFromSession(session);
        List<DiaryResponse> diaries = diaryService.findAll(userId);
        return new ResponseEntity<>(diaries, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DiaryResponse> addDiary(HttpSession session, @RequestBody @Valid DiaryRequest diaryRequest) {
        Long userId = getUserIdFromSession(session);
        DiaryResponse addedDiary = diaryService.addDiary(userId, diaryRequest);
        log.info("addedDiary = " + addedDiary);
        return new ResponseEntity<>(addedDiary, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiaryResponse> editDiary(HttpSession session, @PathVariable Long id, @RequestBody @Valid DiaryRequest diaryRequest) {
        Long userId = getUserIdFromSession(session);
        DiaryResponse updatedDiary = diaryService.updateDiary(userId, id, diaryRequest);
        log.info("updatedDiary = " + updatedDiary);
        return new ResponseEntity<>(updatedDiary, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> deleteDiary(HttpSession session, @PathVariable Long id) {
        Long userId = getUserIdFromSession(session);
        Diary deletedDiary = diaryService.deleteDiary(userId, id);
        log.info("deletedDiary = " + deletedDiary);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
