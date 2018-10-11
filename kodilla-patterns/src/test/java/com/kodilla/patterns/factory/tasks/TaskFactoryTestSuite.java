package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TaskFactoryTestSuite {
    private static TaskFactory taskFactory;

    @BeforeClass
    public static void initTaskFactory(){
        taskFactory = new TaskFactory();
    }
    @Test
    public void testFactoryDriving(){
        Task driveTask = taskFactory.makeTask(Tasks.DRIVING_TASK);

        driveTask.executeTask();

        Assert.assertEquals("Drive", driveTask.getTaskName());
        Assert.assertTrue(driveTask.isTaskDone());
    }

    @Test
    public void testFactoryPainting(){
        Task paintTask = taskFactory.makeTask(Tasks.PAINTING_TASK);

        paintTask.executeTask();

        Assert.assertEquals("Paint", paintTask.getTaskName());
        Assert.assertTrue(paintTask.isTaskDone());
    }

    @Test
    public void testFactoryShopping(){
        Task shopTask = taskFactory.makeTask(Tasks.SHOPPING_TASK);

        Assert.assertEquals("Buy", shopTask.getTaskName());
        Assert.assertFalse(shopTask.isTaskDone());
    }
}
