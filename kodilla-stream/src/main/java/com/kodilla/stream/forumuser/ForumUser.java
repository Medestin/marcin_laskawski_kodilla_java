package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final String username;
    private final int id;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int postCount;

    public ForumUser(String username, int id, char sex, LocalDate dateOfBirth, int postCount) {
        this.username = username;
        this.id = id;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.postCount = postCount;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostCount() {
        return postCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", postCount=" + postCount +
                '}';
    }
}
