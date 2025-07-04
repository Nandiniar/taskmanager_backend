package com.task.taskmanager.dao;

import com.task.taskmanager.Entity.project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "emailcheck",path="emailcheck")
public interface emailcheck extends JpaRepository<project,Long> {


}
