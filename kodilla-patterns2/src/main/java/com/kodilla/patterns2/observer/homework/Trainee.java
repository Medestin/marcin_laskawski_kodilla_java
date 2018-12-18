package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trainee implements Observable {
    private final List<Observer> observers;
    private final Set<Task> tasks;
    private final String traineeName;

    public Trainee(String traineeName) {
        this.observers = new ArrayList<>();
        this.tasks = new HashSet<>();
        this.traineeName = traineeName;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void addTask(Task task){
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
