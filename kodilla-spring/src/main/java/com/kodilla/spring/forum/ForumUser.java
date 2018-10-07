package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public final class ForumUser {
    private String name;

    public ForumUser(){
        this.name = "Richard Rahl";
    }

    public String getName() {
        return name;
    }
}
