package com.task.taskmanager.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
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



@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="assigned_to",nullable=false)
@JsonBackReference
    private registered_user assignedto;

    @Enumerated(EnumType.STRING)
    @Column(name="priority",nullable=false)
    private priority Priority=priority.MEDIUM;

    @Column(name="due_date")
    private Date  due_date;



    @Column(name="created_at")
    private LocalDateTime created_at=LocalDateTime.now();


    @Column(name="updated_at")

    private LocalDateTime updated_at=LocalDateTime.now();


@Column(name="notification")
private String notification;
    @Enumerated(EnumType.STRING)
    @Column(name="label",nullable=false)
    private label Label=label.FEATURE;


  public  enum priority {
        LOW,MEDIUM,HIGH
    }
public enum label{
      FEATURE,BUG,FRONTEND,BACKEND
}





}
