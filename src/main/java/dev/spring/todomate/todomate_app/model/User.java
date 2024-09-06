package dev.spring.todomate.todomate_app.model;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder
@ToString
@Getter
@Table(name="users")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class User extends BaseEntity {

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_password")
    private String password;
}
