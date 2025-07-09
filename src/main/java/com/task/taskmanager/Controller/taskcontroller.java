package com.task.taskmanager.Controller;

import com.task.taskmanager.Entity.registered_user;
import com.task.taskmanager.Entity.task_table;
import com.task.taskmanager.dao.registered_userrepo;
import com.task.taskmanager.dao.tasktablerepo;
import jakarta.persistence.Id;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.rmi.server.LogStream.log;

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


        task.setAssignedto(user.get());


        task.setCreated_at(LocalDateTime.now());
        task.setUpdated_at(LocalDateTime.now());

        task_table savedTask = taskRepository.save(task);

        response.put("message", "Task created successfully");
        response.put("taskId", String.valueOf(savedTask.getId()));
        response.put("assignedTo", user.get().getEmail());

        return ResponseEntity.ok(response);
    }


    @GetMapping("/show-task")
    public ResponseEntity<?>showtask(HttpSession session){ // yaha ? means hai ke kuch bhi return kar sakta hai
        Long userId=(Long) session.getAttribute("userId");
        if(userId==null){
            Map<String,String> response = new HashMap<>();
            response.put("message","Please Login First");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        // optional is used to prevent NullPointerExceptionError means ke optional me agar koi mila tab bhui shi and
        // agar kuch reponse nhi aaya ya kuch nbi mila tab bhi kaam chal jayega error nhi aayega


        // yeh id nikalege jo bhi user login hai
        Optional<registered_user>user=userRepository.findById(userId);
        if(!user.isPresent()){
            Map<String,String> response=new HashMap<>();
response.put("message","User not Found");

return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }




        // to fetch all task  based on assignee userId
        List<task_table>tasks=taskRepository.findByassignedto(user.get());
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/delete-task/{id}")
    public ResponseEntity<Map<String,String>>deletetask(@PathVariable Long id,HttpSession session) {
        Map<String,String>response=new HashMap<>();


        Long userid = (Long) session.getAttribute("userId");
        if (userid == null) {

            response.put("message","Please Login First");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);

        }
        if (!taskRepository.existsById(id)) {
            response.put("message","Task Not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        taskRepository.deleteById(id);
        response.put("message","Deleted Successfully");
        return ResponseEntity.ok(response);

    }

    @PutMapping("/update-task/{id}")
    public ResponseEntity<Map<String,String>>updatetask(@PathVariable Long id,@RequestBody task_table taskt) {
        Map<String, String>response=new HashMap<>();
        Optional<task_table>table=taskRepository.findById(id);

        if(!table.isPresent()){
        response.put("message","No task present");
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        task_table existingtable=table.get();
        existingtable.setTitle(taskt.getTitle());
        existingtable.setNotification(taskt.getNotification());
        existingtable.setPriority(taskt.getPriority());
        existingtable.setDue_date(taskt.getDue_date());
        existingtable.setLabel(taskt.getLabel());
        existingtable.setDescription(taskt.getDescription());
        taskRepository.save(existingtable);
        response.put("message","Task updated Successfully");
        return ResponseEntity.ok(response);
    }

}