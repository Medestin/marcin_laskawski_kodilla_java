package com.kodilla.patterns.factory.tasks;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class ShoppingTask implements Task {
    private static final Logger logger = Logger.getLogger(Logger.class.getName());
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean done;

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
        if (!done) {
            done = true;
            logger.log(Level.INFO, taskName + " executed.");
        } else {
            logger.warning(taskName + " alreadyDone!");
        }
    }

    @Override
    public boolean isTaskDone() {
        return done;
    }
}
