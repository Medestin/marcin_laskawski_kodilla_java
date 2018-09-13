package com.kodilla.testing.forum.statistics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsTestSuite {

    //at the end of each test name there is a formula UxPxCx informing about
    // numbers of Users/Posts/Comments used for the test

    @Test
    public void testStatisticsCounterU0P0C0(){

        Statistics statisticsMock = mock(Statistics.class);

        List<String> forumUsersList = new ArrayList<>();

        when(statisticsMock.usersNames()).thenReturn(forumUsersList);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(0);

        StatisticsCounter statisticsCounter = new StatisticsCounter(statisticsMock);
        assertEquals(statisticsCounter.getAvgPostsPerUser(), 0.0);
        assertEquals(statisticsCounter.getAvgCommentsPerUser(), 0.0);
        assertEquals(statisticsCounter.getAvgCommentsPerPost(), 0.0);

    }


    @Test
    public void testStatisticsCounterU100P0C0(){
        Statistics statisticsMock = mock(Statistics.class);

        List<String> forumUsersList = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            forumUsersList.add("x");
        }

        when(statisticsMock.usersNames()).thenReturn(forumUsersList);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(0);

        StatisticsCounter statisticsCounter = new StatisticsCounter(statisticsMock);
        assertEquals(statisticsCounter.getAvgPostsPerUser(), 0.0);
        assertEquals(statisticsCounter.getAvgCommentsPerUser(), 0.0);
        assertEquals(statisticsCounter.getAvgCommentsPerPost(), 0.0);

    }

    @Test
    public void testStatisticsCounterU100P1000C0(){
        Statistics statisticsMock = mock(Statistics.class);

        List<String> forumUsersList = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            forumUsersList.add("x");
        }

        when(statisticsMock.usersNames()).thenReturn(forumUsersList);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(1000);

        StatisticsCounter statisticsCounter = new StatisticsCounter(statisticsMock);
        assertEquals(statisticsCounter.getAvgPostsPerUser(), 10.0);
        assertEquals(statisticsCounter.getAvgCommentsPerUser(), 0.0);
        assertEquals(statisticsCounter.getAvgCommentsPerPost(), 0.0);

    }

    @Test
    public void testStatisticsCounterU100P1000C100(){
        Statistics statisticsMock = mock(Statistics.class);

        List<String> forumUsersList = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            forumUsersList.add("x");
        }

        when(statisticsMock.usersNames()).thenReturn(forumUsersList);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.postsCount()).thenReturn(1000);

        StatisticsCounter statisticsCounter = new StatisticsCounter(statisticsMock);
        assertEquals(statisticsCounter.getAvgPostsPerUser(), 10.0);
        assertEquals(statisticsCounter.getAvgCommentsPerUser(), 1.0);
        assertEquals(statisticsCounter.getAvgCommentsPerPost(), 0.1);

    }

    @Test
    public void testStatisticsCounterU100P1000C2000(){
        Statistics statisticsMock = mock(Statistics.class);

        List<String> forumUsersList = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            forumUsersList.add("x");
        }

        when(statisticsMock.usersNames()).thenReturn(forumUsersList);
        when(statisticsMock.commentsCount()).thenReturn(2000);
        when(statisticsMock.postsCount()).thenReturn(1000);

        StatisticsCounter statisticsCounter = new StatisticsCounter(statisticsMock);
        assertEquals(statisticsCounter.getAvgPostsPerUser(), 10.0);
        assertEquals(statisticsCounter.getAvgCommentsPerUser(), 20.0);
        assertEquals(statisticsCounter.getAvgCommentsPerPost(), 2.0);

    }

    @Test
    public void testStatisticsCounterU50P123C468(){
        Statistics statisticsMock = mock(Statistics.class);

        List<String> forumUsersList = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            forumUsersList.add("x");
        }

        when(statisticsMock.usersNames()).thenReturn(forumUsersList);
        when(statisticsMock.commentsCount()).thenReturn(468);
        when(statisticsMock.postsCount()).thenReturn(123);

        StatisticsCounter statisticsCounter = new StatisticsCounter(statisticsMock);
        assertEquals(statisticsCounter.getAvgPostsPerUser(), 123.0 / 50.0);
        assertEquals(statisticsCounter.getAvgCommentsPerUser(), 468.0 / 50.0);
        assertEquals(statisticsCounter.getAvgCommentsPerPost(), 468.0 / 123.0);

    }
}
