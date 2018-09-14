package com.kodilla.stream.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverageOfTwos(){
        int[] justTwos = new int[10];
        for(int i = 0; i < justTwos.length; i++){
            justTwos[i] = 2;
        }

        double result = ArrayOperations.getAverage(justTwos);
        assertEquals(2.0, result, 0.0);

    }

    @Test
    public void testGetAverageOfEmpty(){
        int[] emptyArray = new int[10];

        double result = ArrayOperations.getAverage(emptyArray);
        assertEquals(0.0, result, 0.0);

    }

    @Test
    public void testGetAverage(){
        int[] emptyArray = new int[6];
        emptyArray[0] = 1;
        emptyArray[1] = 2;
        emptyArray[2] = 3;
        emptyArray[3] = 4;
        emptyArray[4] = 5;
        emptyArray[5] = 6;

        double result = ArrayOperations.getAverage(emptyArray);
        assertEquals(3.5, result, 0.0);

    }




}
