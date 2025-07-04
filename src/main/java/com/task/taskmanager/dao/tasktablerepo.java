package com.task.taskmanager.dao;

import com.task.taskmanager.Entity.task_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "tasktable",path="tasktable")
public interface tasktablerepo extends JpaRepository<task_table,Long> {
}
