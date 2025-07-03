package com.task.taskmanager.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name="comments")
@Entity

public class comments {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="task_id",nullable=false)
    private task_table task_id;


@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn (name="user_id",nullable = false)
    private users user_id;

@Column(name="comment",nullable=false)
    private String comment;

@Column(name="created_at")
    private LocalDateTime created_at=LocalDateTime.now();

}
