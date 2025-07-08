package com.task.taskmanager.dao;


import com.task.taskmanager.Entity.comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "comments",path="comments")
public interface commentsrepo extends JpaRepository<comments,Long> {
}

