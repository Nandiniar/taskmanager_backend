package com.task.taskmanager.Controller;

import com.task.taskmanager.Entity.registered_user;
import com.task.taskmanager.Entity.task_table;
import com.task.taskmanager.dao.registered_userrepo;
import com.task.taskmanager.dao.tasktablerepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class taskcontroller {
    @Autowired
    private tasktablerepo taskRepository;

    @Autowired
    private registered_userrepo userRepository;

    @PostMapping("/create-task")
    public ResponseEntity<Map<String, String>> createTask(@RequestBody task_table task, HttpSession session) {
        Map<String, String> response = new HashMap<>();

        // Check if user is logged in
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            response.put("message", "Please login first");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        // Find the logged-in user
        Optional<registered_user> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            response.put("message", "User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        // Set the assigned_to field to the current logged-in user
        task.setAssigned_to(user.get());

        // Set timestamps
        task.setCreated_at(LocalDateTime.now());
        task.setUpdated_at(LocalDateTime.now());

        // Save the task
        task_table savedTask = taskRepository.save(task);

        response.put("message", "Task created successfully");
        response.put("taskId", String.valueOf(savedTask.getId()));
        response.put("assignedTo", user.get().getEmail());

        return ResponseEntity.ok(response);
    }
}