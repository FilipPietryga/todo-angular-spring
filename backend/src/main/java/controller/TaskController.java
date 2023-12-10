package controller;

import model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.TaskRepository;

import java.util.List;

@RestController
@CrossOrigin(origins="https://localhost:4200")
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
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
