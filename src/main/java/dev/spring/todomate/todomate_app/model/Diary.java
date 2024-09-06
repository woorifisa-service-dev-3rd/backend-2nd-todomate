package dev.spring.todomate.todomate_app.model;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
@Entity
@Getter
@Table(name="diaries")
public class Diary extends BaseEntity{
    private String title;
    private String content;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
