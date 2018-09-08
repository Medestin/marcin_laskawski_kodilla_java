package com.kodilla.testing.forum.statistics;

public class StatisticsCounter {

    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }

    public double countAvgPostsPerUser(){
        if(numberOfUsers == 0){
            return 0;
        } else return (double) numberOfPosts / (double) numberOfUsers;
    }

    public double countAvgCommentsPerUser(){
        if(numberOfUsers == 0){
            return 0;
        } else return (double) numberOfComments / (double) numberOfUsers;
    }

    public double countAvgCommentsPerPost(){
        if(numberOfPosts == 0){
            return 0;
        } else return (double) numberOfComments / (double) numberOfPosts;
    }

    public void calculateAdvStatistics(Statistics statistics){
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();
        avgPostsPerUser = countAvgPostsPerUser();
        avgCommentsPerUser = countAvgCommentsPerUser();
        avgCommentsPerPost = countAvgCommentsPerPost();
    }

    public void showStatistics(){
        System.out.println("Users counted: " + numberOfUsers);
        System.out.println("Posts counted: " + numberOfPosts);
        System.out.println("Comments counted: " + numberOfComments);
        System.out.println("Average no. of posts per user: " + avgPostsPerUser);
        System.out.println("Average no. of comments per user: " + avgCommentsPerUser);
        System.out.println("Average no. of comments per post: " + avgCommentsPerPost);
    }

}
