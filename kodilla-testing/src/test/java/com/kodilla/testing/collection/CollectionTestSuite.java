package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionTestSuite {

    @Before
    public void before() {
        System.out.println("Test Case: OddNumbersExterminator begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: OddNumbersExterminator end");
    }

    @Test
    public void testDiscardOddNumbersEmptyList() {
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> emptyArrayList = new ArrayList<>();
        List<Integer> filteredArrayList = new ArrayList<>(oddNumbersExterminator.discardUnevenNumbers(emptyArrayList));
        Assert.assertTrue(filteredArrayList.isEmpty());
    }

    @Test
    public void testDiscardOddNumbersNormalList() {
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        List<Integer> integerList = IntStream.range(0, 500).boxed().collect(Collectors.toList());
        oddNumbersExterminator.discardUnevenNumbers(integerList).forEach(e -> Assert.assertEquals(0, e % 2));
    }

}