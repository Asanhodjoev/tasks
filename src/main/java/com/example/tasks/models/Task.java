package com.example.tasks.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.Date;

@NoArgsConstructor
public class Task implements Comparable<Task> {

    private int id;
    private volatile String name;
    private volatile String description;
    private volatile Date date = new Date();

    static volatile int counter = 0;

    public Task(String name, String description) {
        id = increment();
        this.name = name;
        this.description = description;
    }

    public Task(int id, String name, String description, Date date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public synchronized int increment(){
        counter++;
        return counter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
        date = new Date();
    }


    public String getDescription() {
        return description;
    }
    public int compareTo(Task task){
        if(date == task.date) return 0;
        else if (date.after(task.date)) return 1;
        else return -1;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
