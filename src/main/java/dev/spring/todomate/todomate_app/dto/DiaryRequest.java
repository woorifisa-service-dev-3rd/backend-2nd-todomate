package dev.spring.todomate.todomate_app.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@Builder
public class DiaryRequest {
    @NotNull
    private String title;

    @NotNull
    private String content;
}
