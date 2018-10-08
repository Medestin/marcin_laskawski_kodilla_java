package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    private static Board board;

    @BeforeClass
    public static void initializeBoard() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        board = context.getBean(Board.class);
    }

    @Test
    public void testTaskAdd() {
        String task1 = "This is task number one";
        String task2 = "This is task number two";
        String task3 = "This is task number three";
        String task4 = "This is task number four";

        board.addTaskToDo(task1);

        board.addAndStartTask(task2);
        board.addTaskToDo(task3);
        board.startTask(task3);

        board.addTaskToDo(task4);
        board.startTask(task4);
        board.finishTask(task4);

        board.printAllTasks();

        Assert.assertEquals(1, board.getTasksToDo().size());
        Assert.assertEquals(2, board.getTasksInProgress().size());
        Assert.assertEquals(1, board.getTasksDone().size());
    }
}
