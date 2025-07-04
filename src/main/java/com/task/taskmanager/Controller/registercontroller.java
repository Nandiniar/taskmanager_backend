package com.task.taskmanager.Controller;

import com.task.taskmanager.Entity.registered_user;
import com.task.taskmanager.dao.registered_userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
public class registercontroller {

    @Autowired
    private registered_userrepo register;

    @PostMapping("/registereduser")
    public ResponseEntity<?> registerUser(@RequestBody registered_user user) {
        Optional<registered_user> checkuser = register.findByEmail(user.getEmail());
        if (checkuser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("User is already present");
        }

        registered_user savedUser = register.save(user);
        return ResponseEntity.ok(savedUser);
    }
}