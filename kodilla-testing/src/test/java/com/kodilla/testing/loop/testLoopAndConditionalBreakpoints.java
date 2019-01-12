package com.kodilla.testing.loop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testLoopAndConditionalBreakpoints {

    @Test
    public void testLoop(){

        long sum = 0;

        for(int i = 0; i < 1000; ++i){
            sum += i;
            System.out.println(i + "th sum = " + sum);
        }

        assertEquals(499500, sum);
    }
}
