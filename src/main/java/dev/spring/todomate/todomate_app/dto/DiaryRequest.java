package dev.spring.todomate.todomate_app.dto;

import javax.validation.constraints.NotNull;

public class DiaryRequest {
    @NotNull
    private String title;

    @NotNull
    private String content;
}
