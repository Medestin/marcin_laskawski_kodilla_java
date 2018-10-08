package com.kodilla.spring.portfolio;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Board {
    private final TaskList tasksToDo;
    private final TaskList tasksInProgress;
    private final TaskList tasksDone;

    public Board(TaskList toDo, TaskList inProgress, TaskList done){
        this.tasksToDo = toDo;
        this.tasksInProgress = inProgress;
        this.tasksDone = done;
    }

    public void addTaskToDo(String task){
        tasksToDo.addTask(task);
    }

    public void startTask(String task){
        if(tasksToDo.containsTask(task)){
            tasksToDo.removeTask(task);
            tasksInProgress.addTask(task);
        } else {
            System.out.println("Invalid task.");
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
            System.out.println("Invalid task.");
        }
    }

    public void printAllTasks(){
        System.out.println("Tasks to do: ");
        tasksToDo.printTasks();
        System.out.println("Tasks in progress: ");
        tasksInProgress.printTasks();
        System.out.println("Tasks done: ");
        tasksDone.printTasks();
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
