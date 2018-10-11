package com.kodilla.patterns.factory.tasks;

public interface Task {
    String getTaskName();
    void executeTask();
    boolean isTaskDone();
}
