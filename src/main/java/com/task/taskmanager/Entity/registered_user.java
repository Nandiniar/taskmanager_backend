package com.task.taskmanager.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="registered_user")
public class registered_user {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role= Role.user;


    enum Role{
        user,admin;
    }


}
