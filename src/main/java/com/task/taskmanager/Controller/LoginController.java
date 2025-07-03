package com.task.taskmanager.Controller;

import com.task.taskmanager.Entity.login;
import com.task.taskmanager.Entity.registered_user;
import com.task.taskmanager.dao.loginuserdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
public class LoginController {

    @Autowired
    private loginuserdao loginuser;

    @PostMapping("/loginuser")
    public Map<String, String> loginuser(@RequestBody login user) {
        Map<String, String> response = new HashMap<>();
        Optional<registered_user> checkuser = loginuser.findByEmail(user.getEmail());

        if (checkuser.isPresent()) {
            if (checkuser.get().getPassword().equals(user.getPassword())) {
                response.put("message", "Login Successful");
            } else {
                response.put("message", "Incorrect Password");
            }
        } else {
            response.put("message", "User Not Found");
        }

        return response;
    }
}