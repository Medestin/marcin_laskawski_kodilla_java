package com.kodilla.patterns.factory.tasks;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class DrivingTask implements Task {
    private static final Logger logger = Logger.getLogger(Logger.class.getName());
    private final String taskName;
    private final String where;
    private final String using;
    private boolean done;

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
