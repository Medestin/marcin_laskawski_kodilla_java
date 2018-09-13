package com.kodilla.testing.forum.statistics;

public final class StatisticsCounter {

    private final int numberOfUsers;
    private final int numberOfPosts;
    private final int numberOfComments;
    private final double avgPostsPerUser;
    private final double avgCommentsPerUser;
    private final double avgCommentsPerPost;

    public StatisticsCounter(Statistics statistics) {
        this.numberOfUsers = statistics.usersNames().size();
        this.numberOfPosts = statistics.postsCount();
        this.numberOfComments = statistics.commentsCount();

        if (this.numberOfUsers == 0) {
            this.avgPostsPerUser = 0.0;
            this.avgCommentsPerUser = 0.0;
        } else {
            this.avgPostsPerUser = (double) this.numberOfPosts / (double) this.numberOfUsers;
            this.avgCommentsPerUser = (double) this.numberOfComments / (double) this.numberOfUsers;
        }

        if (this.numberOfPosts == 0) {
            this.avgCommentsPerPost = 0.0;
        } else {
            this.avgCommentsPerPost = (double) this.numberOfComments / (double) this.numberOfPosts;
        }

    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }

}
