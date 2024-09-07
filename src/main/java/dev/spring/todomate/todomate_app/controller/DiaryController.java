package dev.spring.todomate.todomate_app.controller;

import dev.spring.todomate.todomate_app.model.Diary;
import dev.spring.todomate.todomate_app.service.DiaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/diaries")
public class DiaryController {

    private final DiaryService diaryService;

    @GetMapping("/list")
    public String diaryList(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        List<Diary> diaries = diaryService.findAll(1L);
        model.addAttribute("diaries", diaries);
        return "diaryList";
    }

    @GetMapping("/add")
    public String showAddDiaryForm(Model model) {
        model.addAttribute(Diary.builder().build());
        return "createOrUpdateDiaryForm";
    }

    @PostMapping("/add")
    public String addDiary(HttpServletRequest request, Diary diary, Model model) {
        System.out.println("Diary = " + diary);
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        Diary newDiary = diaryService.addDiary(1L, diary);
        return "redirect:/diaries/list";
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
