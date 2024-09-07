package dev.spring.todomate.todomate_app.model;

import lombok.*;

import javax.persistence.*;

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
    private String username;

    @Column(name = "user_password")
    private String password;
}
