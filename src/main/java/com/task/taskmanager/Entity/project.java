package com.task.taskmanager.Entity;


import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


import java.time.LocalDateTime;

@Entity
@Data
@Table(name="project")
public class project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="project_name",nullable = false,length=255)
    private String project_name;

    @Column(name="description",nullable=false,length=255)
    private  String description;
@ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn (name="created_by",nullable=false)
    private users created_by;

    @Enumerated(EnumType.STRING)
    @Column(name="status",nullable=false)
    private Status status=Status.ACTIVE;


    @Column(name="start_date")
public LocalDateTime start_date=LocalDateTime.now();


    @Column(name="end_date")
    public LocalDateTime end_date=LocalDateTime.now();
    @OneToMany(mappedBy="project_id",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
private List<project_member>proj;

    public enum Status{
        ACTIVE,COMPLETED,ONHOLD
    }

}

