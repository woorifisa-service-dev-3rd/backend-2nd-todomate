package dev.spring.todomate.todomate_app.dto;

import dev.spring.todomate.todomate_app.model.Diary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class DiaryResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDate date;

    public static DiaryResponse from (Diary diary) {
        return DiaryResponse.builder()
                .id(diary.getId())
                .title(diary.getTitle())
                .content(diary.getContent())
                .date(diary.getDate())
                .build();
    }
}
