package com.task.taskmanager.Controller;

import com.task.taskmanager.Entity.login;
import com.task.taskmanager.Entity.registered_user;
import com.task.taskmanager.dao.loginuserdao;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.rmi.server.LogStream.log;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class LoginController {

    @Autowired
    private loginuserdao loginuser;

    @PostMapping("/loginuser")
    public Map<String, String> loginuser(@RequestBody login user, HttpSession session) {
        Map<String, String> response = new HashMap<>();
        Optional<registered_user> checkuser = loginuser.findByEmail(user.getEmail());

        if (checkuser.isPresent()) {
            if (checkuser.get().getPassword().equals(user.getPassword())) {
                session.setAttribute("userId",checkuser.get().getId());

                session.setAttribute("userEmail",checkuser.get().getEmail());
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