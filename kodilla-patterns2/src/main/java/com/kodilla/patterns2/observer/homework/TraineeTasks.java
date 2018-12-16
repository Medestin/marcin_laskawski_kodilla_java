package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class TraineeTasks implements Observable {
    private final List<Observer> observers;
    private final List<String> tasks;
    private final String traineeName;

    public TraineeTasks(String traineeName) {
        this.observers = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.traineeName = traineeName;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void addTask(String task){
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}
