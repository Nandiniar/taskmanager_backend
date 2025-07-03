package com.task.taskmanager.Entity;


import jakarta.persistence.*;
import lombok.Data;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="column_table")
public class column_table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name",nullable=false,length=255)
    private String name;

   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id",nullable=false)
    private board_table board_id;

    @Column(name="column_order",nullable=false)
    private int column_order;

    @Column(name="created_at")
    private LocalDateTime created_at=LocalDateTime.now();

    @OneToMany(mappedBy="column_id",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<task_table>columntask;
}
