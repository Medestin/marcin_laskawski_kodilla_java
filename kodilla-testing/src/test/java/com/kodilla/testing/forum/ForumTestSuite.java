package com.kodilla.testing.forum;

import 
import org.junit.Test;

public class ForumTestSuite {

    @Test
    public void testCaseUsername(){
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        //When
        String result = simpleUser.getUsername();
        //Then
        Assert.assertEquals("theForumUser", result);
    }

}
