package com.task.taskmanager.dao;

import com.task.taskmanager.Entity.project_member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "projectmember",path="projectmember")
public interface projectmemberrepo extends JpaRepository<project_member,Long> {
}
