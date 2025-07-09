package com.task.taskmanager.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="project_member")
public class project_member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")

    private users user_id;
@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="project_id")

    private  project project_id;

    @Column(name="added_at")
    private LocalDateTime added_at=LocalDateTime.now();
}
