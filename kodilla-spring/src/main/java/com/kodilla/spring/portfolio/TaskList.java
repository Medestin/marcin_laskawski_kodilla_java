package com.kodilla.spring.portfolio;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public final class TaskList {
    private final List<String> tasks;

    public TaskList(){
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task){
        tasks.add(task);
    }

    public void removeTask(String task){
        tasks.remove(task);
    }

    public boolean containsTask(String task){
        return tasks.contains(task);
    }

    public void printTasks(){
        System.out.println(tasks);
    }

    public List<String> getTasks(){
        return new ArrayList<>(tasks);
    }
}
