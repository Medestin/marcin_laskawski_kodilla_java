package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String TASKLISTNAME = "TestList";

    @Test
    public void testFindByListName(){
        TaskList taskList = new TaskList(TASKLISTNAME, "This is a test TaskList object");
        taskListDao.save(taskList);
        long numberOfEntitiesInDatabase = taskListDao.count();

        List<TaskList> readTaskList = taskListDao.findByListName(TASKLISTNAME);
        Assert.assertEquals(1, readTaskList.size());

        taskListDao.deleteByListName(TASKLISTNAME);
        Assert.assertEquals(numberOfEntitiesInDatabase-1, taskListDao.count());
    }
}
