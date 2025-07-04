package com.task.taskmanager.dao;

import com.task.taskmanager.Entity.column_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "column",path="column")
public interface columntable  extends JpaRepository<column_table,Long> {
}
