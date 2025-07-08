package com.task.taskmanager.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
    @OneToMany(mappedBy="assigned_to",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<task_table> task;
}