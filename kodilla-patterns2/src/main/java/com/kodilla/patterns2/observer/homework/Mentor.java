package com.kodilla.patterns2.observer.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class Mentor implements Observer {
    private final static Logger LOGGER = LoggerFactory.getLogger(Mentor.class);
    private final String name;
    private AtomicInteger count;

    public Mentor(String name) {
        this.name = name;
        count = new AtomicInteger(0);
    }

    public AtomicInteger getCount() {
        return count;
    }

    @Override
    public void update(Trainee trainee) {
        LOGGER.info(this.name + " has a new task to check, submitted by: " + trainee.getTraineeName());
        count.compareAndSet(count.intValue(), count.intValue()+1);
    }

    public void acceptTask(Task task){
        task.acceptTask();
    }
}
