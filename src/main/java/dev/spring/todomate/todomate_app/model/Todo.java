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
@Table(name="todos")
@AttributeOverride(name= "id", column = @Column(name = "todo_id"))
public class Todo extends BaseEntity{

    @Column(name = "todo_title")
    private String title;

    @Column(name = "todo_summary")
    private String summary;

    @Enumerated(EnumType.STRING)
    @Column(name = "todo_options")
    private Option option;

    @Column(name = "todo_startdate")
    private LocalDate startDate;

    @Column(name = "todo_duedate")
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
}
