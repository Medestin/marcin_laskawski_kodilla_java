package com.kodilla.spring.forum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ForumUserTestSuite {
    @Test
    public void testGetUsername(){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.kodilla.spring.forum");
        ForumUser forumUser = applicationContext.getBean(ForumUser.class);

        String greatName = forumUser.getName();

        Assert.assertEquals("Richard Rahl", greatName);
    }
}
