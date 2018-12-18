package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class TraineeTestSuite {

    @Test
    public void testUpdate(){
        Trainee marcin = new Trainee("Marcin Laskawski");
        Trainee mikolaj = new Trainee("Mikolaj Kopernik");
        Trainee krzysztof = new Trainee("Krzysztof Kolumb");
        Mentor maciek = new Mentor("Maciek Prokopiuk");
        Mentor internety = new Mentor("Wujek Google");

        marcin.registerObserver(maciek);
        marcin.registerObserver(internety);
        mikolaj.registerObserver(maciek);
        krzysztof.registerObserver(internety);

        marcin.addTask(new Task(1.1, "do roboty sie zabierz!"));
        marcin.addTask(new Task(1.2, "przestan sie lenic!"));
        marcin.addTask(new Task(20.4, "Observer & Observable"));
        mikolaj.addTask(new Task(2.2, "ruszyc ziemie"));
        krzysztof.addTask(new Task(14.92, "Odkryc Ameryke ale nie wiedziec ze to Ameryka"));

        assertEquals(4, maciek.getCount().intValue());
        assertEquals(4, internety.getCount().intValue());

        Task thisTask = marcin.getTasks().stream().filter(task -> task.getTaskId() == 20.4).findFirst().get();
        maciek.acceptTask(thisTask);
    }
}