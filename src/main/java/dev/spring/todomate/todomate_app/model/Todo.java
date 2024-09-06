package dev.spring.todomate.todomate_app.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Builder
@ToString
@Entity
@Getter
@Table(name="todos")
@AttributeOverride(name= "id", column = @Column(name = "todo_id"))
public class Todo extends BaseEntity{

    // DB와 매핑하지 않음
    @Transient
    private Long dayUntilDue;

    @Column(name = "todo_title", nullable = false)
    private String title;

    @Column(name = "todo_summary", nullable = false)
    private String summary;

    @Enumerated(EnumType.STRING)
    @Column(name = "todo_options", nullable = false)
    private Option option;

    @Column(name = "todo_startdate", nullable = false)
    private LocalDate startDate;

    @Column(name = "todo_duedate", nullable = false)
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name="users_user_id")
    private User user;

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDayUntilDue(Long dayUntilDue) {
        this.dayUntilDue = dayUntilDue;
    }
}
