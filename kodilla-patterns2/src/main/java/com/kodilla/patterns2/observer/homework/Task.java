package com.kodilla.patterns2.observer.homework;

import java.util.Objects;

public class Task {
    private final double taskId;
    private final String name;
    private boolean isAccepted;

    public Task(double taskId, String name) {
        this.taskId = taskId;
        this.name = name;
    }

    public double getTaskId() {
        return taskId;
    }

    public void acceptTask(){
        isAccepted = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Double.compare(task.taskId, taskId) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }
}
