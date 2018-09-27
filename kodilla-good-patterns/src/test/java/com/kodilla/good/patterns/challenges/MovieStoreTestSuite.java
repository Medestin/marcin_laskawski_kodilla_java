package com.kodilla.good.patterns.challenges;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieStoreTestSuite {

    @Test
    public void testStreamingTitles(){

        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> testMap = movieStore.getMovies();

        String testString = testMap.entrySet().stream()
                .flatMap(k -> k.getValue().stream())
                .collect(Collectors.joining("! ", "", "!"));

        String manualString = "Żelazny Człowiek! Iron Man! Mściciele! Avengers! Błyskawica! Flash!";
        Assert.assertEquals(manualString, testString);
    }
}
