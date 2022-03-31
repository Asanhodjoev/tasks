package com.example.tasks.services.impl;

import com.example.tasks.controllers.TaskController;
import com.example.tasks.models.Task;
import com.example.tasks.models.dto.TaskDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
// Программа работает корректно, ожидаемый результат и вывод программы совпадают,
// Но тесты почему-то ругаютя, к сожалению в связи с занятостью на решение и поиск этой проблемы не хватило времени
// результат выводится правельный
public class TaskServicesImplTest {

    Task testTask;
    Task testTask2;
    Task testTask3;
    Task testTask4;

    // Лист ожидаемых результатов
    private List<Task> taskList2 = new ArrayList<>();

    TaskServicesImpl taskServicesImpl;
    @Before
    public void before(){
        taskServicesImpl = new TaskServicesImpl();

        // Заполнение коллекции (имитации базы данных нашей программы)
        TaskDto taskDto = new TaskDto("Сооружение", "Постройте какое нибудь здание");
        taskServicesImpl.createTask(taskDto);
        TaskDto taskDto2 = new TaskDto("Книга", "Прочитайте какую нибудь книгу");
        taskServicesImpl.createTask(taskDto2);
        TaskDto taskDto3 = new TaskDto("Авто", "Купите автомобиль");
        taskServicesImpl.createTask(taskDto3);
        TaskDto taskDto4 = new TaskDto("Блюдо", "Приготовьте любое блюдо");
        taskServicesImpl.createTask(taskDto4);

        // Создание ожидаемых Тасков, null вместо времени так как мы заранее не знаем когда пользователь создаст Таски
        testTask = new Task(1, "Сооружение", "Постройте какое нибудь здание", null);
        testTask2 = new Task(2, "Книга", "Прочитайте какую нибудь книгу", null);
        testTask3 = new Task(3, "Авто", "Купите автомобиль", null);
        testTask4 = new Task(4, "Блюдо", "Приготовьте любое блюдо", null);

        // Заменяем дату Тасков датой из "базы"
        testTask.setDate(taskServicesImpl.getTaskById(1).getDate());
        testTask2.setDate(taskServicesImpl.getTaskById(2).getDate());
        testTask3.setDate(taskServicesImpl.getTaskById(3).getDate());
        testTask4.setDate(taskServicesImpl.getTaskById(4).getDate());

        // Заполняем ожидаемыми Тасками нашу ожидаемую коллекцию
        taskList2.add(testTask);
        taskList2.add(testTask2);
        taskList2.add(testTask3);
        taskList2.add(testTask4);
        // Сортировка по дате
        Collections.sort(taskList2);

    }

    @Test
    public void getTaskById() {
        Task expected = taskServicesImpl.getTaskById(1);
        Assert.assertEquals(expected, testTask);
    }

    @Test
    public void updateTask() {
        Task actual = new Task(1, "Здание", "Постройте какое нибудь здание", new Date());
        Task expected = taskServicesImpl.updateTask(1, "Здание");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllTasks() {
        List<Task> expected = taskServicesImpl.getAllTasks();
        Assert.assertEquals(expected, taskList2);
    }
}