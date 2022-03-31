package com.example.tasks;

import com.example.tasks.controllers.TaskController;
import com.example.tasks.models.Task;
import com.example.tasks.models.dto.TaskDto;
import com.example.tasks.services.impl.TaskServicesImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TasksApplicationTests {
    Task task;
    Task task2;
    Task task3;
    Task task4;

    List<Task> taskList2 = new ArrayList<>();

    @Before
    public void before(){
        TaskServicesImpl taskServicesiml = new TaskServicesImpl();
        TaskDto taskDto = new TaskDto("Сооружение", "Постройте какое нибудь здание");
        taskServicesiml.createTask(taskDto);
        TaskDto taskDto2 = new TaskDto("Книга", "Прочитайте какую нибудь книгу");
        taskServicesiml.createTask(taskDto2);
        TaskDto taskDto3 = new TaskDto("Авто", "Купите автомобиль");
        taskServicesiml.createTask(taskDto3);
        TaskDto taskDto4 = new TaskDto("Блюдо", "Приготовьте любое блюдо");
        taskServicesiml.createTask(taskDto4);

        Task testTask = new Task(1, "Сооружение", "Постройте какое нибудь здание", null);
        Task testTask2 = new Task(2, "Книга", "Прочитайте какую нибудь книгу", null);
        Task testTask3 = new Task(3, "Авто", "Купите автомобиль", null);
        Task testTask4 = new Task(4, "Блюдо", "Приготовьте любое блюдо", null);

//        testTask.setDate(taskController.getTaskById(1).getDate());
//        testTask2.setDate(taskController.getTaskById(2).getDate());
//        testTask3.setDate(taskController.getTaskById(3).getDate());
//        testTask4.setDate(taskController.getTaskById(4).getDate());

        taskList2.add(testTask);
        taskList2.add(testTask2);
        taskList2.add(testTask3);
        taskList2.add(testTask4);

    }

    @Test
    void contextLoads() {
    }

}
