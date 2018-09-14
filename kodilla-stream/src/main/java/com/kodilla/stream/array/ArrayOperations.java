package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers){

        java.util.Arrays.stream(numbers, 0, numbers.length)
                .forEach(System.out::print);

        return IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average().orElse(0.0);
    }
}
