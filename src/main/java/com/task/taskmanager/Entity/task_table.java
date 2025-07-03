package com.task.taskmanager.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name="task_table")
@Entity
public class task_table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title",nullable = false,length=255)
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="column_id",nullable=false)
    private Long column_id;

@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="assigned_to",nullable=false)
    private users assigned_to;

    @Enumerated(EnumType.STRING)
    @Column(name="priority",nullable=false)
    private priority Priority=priority.MEDIUM;

    @Column(name="due_date")
    private LocalDateTime due_date=LocalDateTime.now();

    @Column(name="task_order",nullable=false)
    private int task_order;

    @Column(name="created_at")
    private LocalDateTime created_at=LocalDateTime.now();


    @Column(name="updated_at")

    private LocalDateTime updated_at=LocalDateTime.now();
@Column(name="day")
private String day;

@Column(name="notification")
private String notification;
    @Enumerated(EnumType.STRING)
    @Column(name="label",nullable=false)
    private label Label=label.FEATURE;

@OneToMany(mappedBy="task_id",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
private List<comments>taskcomment;


  public  enum priority {
        LOW,MEDIUM,HIGH
    }
public enum label{
      FEATURE,BUG,FRONTEND,BACKEND
}





}
