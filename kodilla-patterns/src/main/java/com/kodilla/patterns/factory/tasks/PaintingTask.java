package com.kodilla.patterns.factory.tasks;

public final class PaintingTask implements Task{
    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private boolean isDone = false;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
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
