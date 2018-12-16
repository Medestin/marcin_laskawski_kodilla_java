package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalaryAdapterTestSuite {

    @Test
    public void testTotalSalary(){
        Workers workers = new Workers();
        SalaryAdapter salaryAdapter = new SalaryAdapter();

        double totalSalary = salaryAdapter.totalSalary(workers.getWorkers(), workers.getSalaries());

        System.out.println(totalSalary);
        assertEquals(27750.00, totalSalary, 0);
    }

}