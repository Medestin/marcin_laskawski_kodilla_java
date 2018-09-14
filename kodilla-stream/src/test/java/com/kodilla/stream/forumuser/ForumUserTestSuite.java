package com.kodilla.stream.forumuser;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ForumUserTestSuite {

    @Test
    public void testFilteringForumUsers(){

        Forum forum = new Forum();
        Map<Integer, ForumUser> filteredUserMap = forum.getUserList().stream()
                .filter(n -> n.getSex() == 'M')
                .filter(ForumUser::isAtLeast20YO)
                .filter(n -> n.getPostCount() > 0)
                .collect(Collectors.toMap(ForumUser::getId, Function.identity()));

        assertEquals(4, filteredUserMap.size());
        assertTrue(filteredUserMap.containsValue(forum.getUserList().get(0)));
        assertTrue(!filteredUserMap.containsValue(forum.getUserList().get(1)));

    }

}
