package com.kodilla.patterns.factory.tasks;

public final class DrivingTask implements Task {
    private final String taskName;
    private final String where;
    private final String using;
    private boolean isDone = false;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public void executeTask() {
        if (!isDone) {
            isDone = true;
            Logger.getInstance().logInfo(taskName + " executed.");
        } else {
            Logger.getInstance().logError(taskName + " alreadyDone!");
        }
    }

    @Override
    public boolean isTaskDone() {
        return isDone;
    }
}
