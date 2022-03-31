package com.example.tasks.services;

import com.example.tasks.models.Task;
import com.example.tasks.models.dto.TaskDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {

    Task createTask(TaskDto taskDto);

    Task getTaskById(Integer id);

    Task updateTask(Integer id, String name);

    ResponseEntity<?> deleteTaskById(Integer id);

    List<Task> getAllTasks();
}
