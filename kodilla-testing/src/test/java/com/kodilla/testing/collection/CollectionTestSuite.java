package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {

    @Before
    public void before(){
        System.out.println("Test Case: OddNumbersExterminator begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: OddNumbersExterminator end");
    }

    @Test
    public void testDiscardOddNumbersEmptyList(){
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> emptyArrayList = new ArrayList<>();
        List<Integer> filteredArrayList = new ArrayList<>(oddNumbersExterminator.discardUnevenNumbers(emptyArrayList));
        filteredArrayList.forEach(e -> Assert.assertEquals(0, e % 2));
    }

    @Test
    public void testDiscardOddNumbersNormalList(){
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> normalArrayList = new ArrayList<>();
        for(int i = 1; i < 50001; i++){
            normalArrayList.add(i);
        }
        List<Integer> filteredArrayList = new ArrayList<>(oddNumbersExterminator.discardUnevenNumbers(normalArrayList));

        filteredArrayList.forEach(e -> Assert.assertEquals(0, e % 2));
    }

}
