package com.task.taskmanager.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class login {
    @Id
    private String email;
    private String password;
}
