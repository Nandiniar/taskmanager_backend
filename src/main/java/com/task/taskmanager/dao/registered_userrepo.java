package com.task.taskmanager.dao;


import com.task.taskmanager.Entity.project;
import com.task.taskmanager.Entity.registered_user;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;



@Repository
public interface registered_userrepo extends JpaRepository<registered_user,Long> {
    Optional<registered_user> findByEmail(String email);
}
