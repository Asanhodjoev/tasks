package com.example.tasks.services.impl;

import com.example.tasks.exeption.UniversalExeption;
import com.example.tasks.models.Task;
import com.example.tasks.models.dto.TaskDto;
import com.example.tasks.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TaskServicesImpl implements TaskService {

    private List<Task> taskList = new ArrayList<>();

    @Override
    public Task createTask(TaskDto taskDto) {

        Task task = new Task(taskDto.getName(), taskDto.getDescription());
        taskList.add(task);
        return task;
    }

    @Override
    public Task getTaskById(Integer id) {
        for (Task task : taskList) {
            if(task.getId() == id) return task;
        }
        throw new UniversalExeption("Ошибка","Задачи с таким id нету!!");
    }

    @Override
    public synchronized Task updateTask(Integer id, String name) {

        for (Task task : taskList) {
            if(task.getId() == id) {
                task.setName(name);
                //---
                return task;
            }
        }
        throw new UniversalExeption("Ошибка","Задача(task) по введенному id отсутствует");
    }

    @Override
    public ResponseEntity<?> deleteTaskById(Integer id) {

        for (Task task : taskList) {
            if(task.getId() == id) {
                int indexForDelete = taskList.indexOf(task);
                Task taskDelete = taskList.remove(indexForDelete);
                if(Objects.isNull(taskDelete)){
                    return ResponseEntity.ok("Ошибка не удается удалить");
                } else return ResponseEntity.ok("Task успешно удален");
            }
        }
        return ResponseEntity.ok("Задача(task) по введенному id отсутствует");
    }

    @Override
    public List<Task> getAllTasks() {
        Collections.sort(taskList);
        return taskList;
    }
}
