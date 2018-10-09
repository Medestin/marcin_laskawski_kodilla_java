package com.kodilla.spring.portfolio;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Board {
    private final static Logger logger = Logger.getLogger(Logger.class.getName());
    private final TaskList tasksToDo;
    private final TaskList tasksInProgress;
    private final TaskList tasksDone;

    public Board(){
        this.tasksToDo = new TaskList();
        this.tasksInProgress = new TaskList();
        this.tasksDone = new TaskList();
    }

    public void addTaskToDo(String task){
        tasksToDo.addTask(task);
    }

    public void startTask(String task){
        if(tasksToDo.containsTask(task)){
            tasksToDo.removeTask(task);
            tasksInProgress.addTask(task);
        } else {
            logger.log(Level.INFO, "Invalid task.");
        }
    }

    public void addAndStartTask(String task){
        tasksInProgress.addTask(task);
    }

    public void finishTask(String task){
        if(tasksInProgress.containsTask(task)){
            tasksInProgress.removeTask(task);
            tasksDone.addTask(task);
        } else {
            logger.log(Level.INFO, "Invalid task.");
        }
    }

    public String toString(){
        return  "Tasks to do: " + tasksToDo.toString() +
                "\nTasks in progress: " + tasksInProgress.toString() +
                "\nTasks done: " + tasksDone.toString();
    }

    public List<String> getTasksToDo() {
        return tasksToDo.getTasks();
    }

    public List<String> getTasksInProgress() {
        return tasksInProgress.getTasks();
    }

    public List<String> getTasksDone() {
        return tasksDone.getTasks();
    }
}
