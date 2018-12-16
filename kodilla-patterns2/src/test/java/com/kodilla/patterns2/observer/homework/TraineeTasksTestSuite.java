package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class TraineeTasksTestSuite {

    @Test
    public void testUpdate(){
        TraineeTasks marcinTasks = new TraineeTasks("Marcin Laskawski");
        TraineeTasks mikolajTasks = new TraineeTasks("Mikolaj Kopernik");
        TraineeTasks krzysztofTasks = new TraineeTasks("Krzysztof Kolumb");
        Mentor maciek = new Mentor("Maciek Prokopiuk");
        Mentor internety = new Mentor("Wujek Google");

        marcinTasks.registerObserver(maciek);
        marcinTasks.registerObserver(internety);
        mikolajTasks.registerObserver(maciek);
        krzysztofTasks.registerObserver(internety);

        marcinTasks.addTask("do roboty sie zabierz!");
        marcinTasks.addTask("przestan sie lenic!");
        mikolajTasks.addTask("ruszyc ziemie");
        krzysztofTasks.addTask("Odkryc Ameryke ale nie wiedziec ze to Ameryka");

        assertEquals(3, maciek.getCount());
        assertEquals(3, internety.getCount());
    }
}