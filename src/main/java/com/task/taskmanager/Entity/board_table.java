package com.task.taskmanager.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="board_table")
public class board_table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name",nullable=false,length=255)
    private String name;

    @Column(name="project_id",nullable=false)
    private Long project_id;

    @Column(name="board_order")
    private int board_order;

    @Column(name="created_at")
    private LocalDateTime created_at=LocalDateTime.now() ;

    @OneToMany(mappedBy = "board_id",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<column_table>boardcolumn;


}
