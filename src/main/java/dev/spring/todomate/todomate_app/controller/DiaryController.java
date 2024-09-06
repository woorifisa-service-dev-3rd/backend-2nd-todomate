package dev.spring.todomate.todomate_app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/diaries")
public class DiaryController {

    @GetMapping("/list")
    public String diaryList() {
        return "diaryList";
    }
}