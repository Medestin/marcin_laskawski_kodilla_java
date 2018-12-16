package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void registerObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObservers();
}
