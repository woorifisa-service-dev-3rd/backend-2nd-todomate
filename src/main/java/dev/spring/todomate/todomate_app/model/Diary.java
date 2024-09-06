package dev.spring.todomate.todomate_app.model;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
@Entity
@Getter
@Setter
@Table(name="diaries")
@AttributeOverride(name = "id", column = @Column(name = "diary_id"))
public class Diary extends BaseEntity{

    @Column(name = "diary_title")
    private String title;

    @Column(name = "diary_content")
    private String content;

    @Column(name = "diary_date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "users_user_id")
    private User user;

    public void updateDiary(Diary diaryToUpdate) {
        this.title = diaryToUpdate.getTitle();
        this.content = diaryToUpdate.getContent();
        this.date = diaryToUpdate.getDate();
    }
}
