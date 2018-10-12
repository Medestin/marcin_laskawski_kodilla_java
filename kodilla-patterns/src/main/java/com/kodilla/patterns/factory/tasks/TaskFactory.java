package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public final Task makeTask(TaskType taskType){
        switch (taskType){
            case DRIVING_TASK:
                return new DrivingTask("Drive", "somewhere", "anything just go away");
            case PAINTING_TASK:
                return new PaintingTask("Paint", "blue", "Your face");
            case SHOPPING_TASK:
                return new ShoppingTask("Buy", "smokes", 2.0);
            default:
                throw new IllegalArgumentException("Unknown TaskType");
        }
    }
}
