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
        System.out.println("title : " + diaryRequest.getTitle() + ", content : " + diaryRequest.getContent());
        DiaryResponse diary = diaryService.addDiary(userId, diaryRequest);
        return new ResponseEntity<>(diary, HttpStatus.CREATED);
    }

    @GetMapping("/{diaryId}/edit")
    public String showEditDiaryForm(@PathVariable Long diaryId, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        Diary foundDiary = diaryService.findById(diaryId);
        model.addAttribute("diary", foundDiary);
        return "createOrUpdateDiaryForm";
    }

    @PostMapping("/{diaryId}/edit")
    public String editDiary(@PathVariable Long diaryId, HttpServletRequest request, Diary diary) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        Diary updatedDiary = diaryService.updateDiary(1L, diaryId, diary);
        log.debug("updatedDiary = " + updatedDiary);
        return "redirect:/diaries/list";
    }

    @PostMapping("/{diaryId}/delete")
    public String deleteDiary(@PathVariable Long diaryId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        diaryService.deleteDiary(1L, diaryId);
        return "redirect:/diaries/list";
    }
}
