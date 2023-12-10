package com.example.springboot.controller;

import com.example.springboot.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.repository.TaskRepository;

import java.util.List;

@RestController
@CrossOrigin(origins="https://localhost:4200")
public class TaskController {

    @Autowired
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    @PostMapping("/task")
    public void addTask(@RequestBody Task task) {
        taskRepository.save(task);
    }
}
