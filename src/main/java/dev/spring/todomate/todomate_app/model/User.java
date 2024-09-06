package dev.spring.todomate.todomate_app.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder
@ToString
@Getter
@Table(name="users")
public class User extends BaseEntity {
    private String name;
    private String password;
}
