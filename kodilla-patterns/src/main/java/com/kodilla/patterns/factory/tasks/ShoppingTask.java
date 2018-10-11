package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Task {
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean isDone = false;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
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
