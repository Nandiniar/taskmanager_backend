package com.task.taskmanager.dao;

import com.task.taskmanager.Entity.board_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "board",path="board")
public interface boardtablerepo extends JpaRepository<board_table,Long> {
}
