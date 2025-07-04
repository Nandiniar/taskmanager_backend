package com.task.taskmanager.dao;

import com.task.taskmanager.Entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "users",path="users")
public interface usersrepo extends JpaRepository<users,String> {
}
