package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;


public class OddNumbersExterminator {

    public List<Integer> discardUnevenNumbers(List<Integer> listOfNumbers){
        List<Integer> filteredList = new ArrayList<>();
        listOfNumbers.forEach(e -> {
            if(e % 2 == 0){
                filteredList.add(e);
            }
        });

        return filteredList;
    }

}
