package com.task.taskmanager.Entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comments;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name="users")
public class users {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

@Column(name="username",nullable = false,length=255)
    private String username;

@Column(name="email",nullable=false,length=255)
    private String email;

@Column(name="password",nullable=false,length=255)
    private String password;

@Column(name="fullname",nullable=false,length=255)
    private String fullname;

@Enumerated(EnumType.STRING)
    @Column(name="role",nullable=false,length=100)
    private Role role =Role.USER;

        @Column(name="created_at")
        private LocalDateTime created_at=LocalDateTime.now();

        @Column(name="is_active",nullable = false)
private boolean is_active=true;

        @Column(name="updated_at")
        private LocalDateTime updated_at=LocalDateTime.now();

@OneToMany(mappedBy = "created_by",cascade=CascadeType.ALL,fetch = FetchType.LAZY) // (cascade=CascadeType.ALL means what will occur with childern will happen with parenys alsp

private List<project>Projects;

@OneToMany(mappedBy="user_id",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
private List<comments>comment;


@OneToMany(mappedBy="user_id",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
private List<project_member>projectmember;




        public enum Role{
    ADMIN,USER
        }



}
