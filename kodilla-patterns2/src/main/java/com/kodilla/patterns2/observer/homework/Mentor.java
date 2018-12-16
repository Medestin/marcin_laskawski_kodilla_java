package com.kodilla.patterns2.observer.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mentor implements Observer {
    private final static Logger LOGGER = LoggerFactory.getLogger(Mentor.class);
    private final String name;
    private int count;

    public Mentor(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void update(TraineeTasks traineeTasks) {
        LOGGER.info(this.name + " has a new task to check, submitted by: " + traineeTasks.getTraineeName());
        count++;
    }
}
