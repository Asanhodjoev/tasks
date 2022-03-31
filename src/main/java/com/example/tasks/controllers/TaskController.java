package com.example.tasks.controllers;

import com.example.tasks.models.Task;
import com.example.tasks.models.dto.TaskDto;
import com.example.tasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public Task createTask(@RequestBody TaskDto taskDto){
        return taskService.createTask(taskDto);
    }

    @GetMapping("/get_task")
    public Task getTaskById(@RequestParam Integer id){
        return taskService.getTaskById(id);
    }

    @PutMapping("/update_task")
    public Task updateTask(@RequestParam Integer id, @RequestParam String name){
        return taskService.updateTask(id, name);
    }

    @DeleteMapping("/delete_task")
    public ResponseEntity<?> deleteTask(@RequestParam Integer id){
        return taskService.deleteTaskById(id);
    }

    @GetMapping("/get_all_tasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
}
