package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {
    private String[][] workers = {
            {"12345678910", "John", "Smith"},
            {"45464516511", "Ivone", "Novak"},
            {"65451818498", "Jessie", "Pinkman"},
            {"12154982658", "Walter", "White"},
            {"15614845123", "Clara", "Lanson"}
    };
    private double[] salaries = {
            4500.00,
            3700.00,
            4350.00,
            9000.00,
            6200.00
    };

    public String getWorker(int n){
        if(n > salaries.length){
            return "";
        } else {
            return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + ", " + salaries[n];
        }
    }

    public String[][] getWorkers(){
        return workers;
    }

    public double[] getSalaries(){
        return salaries;
    }
}
