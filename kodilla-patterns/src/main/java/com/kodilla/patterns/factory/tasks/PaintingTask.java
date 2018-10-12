package com.kodilla.patterns.factory.tasks;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class PaintingTask implements Task{
    private static final Logger logger = Logger.getLogger(Logger.class.getName());
    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private boolean done;

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
