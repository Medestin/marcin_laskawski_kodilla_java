package com.kodilla.stream.beautifier;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BeautifierTestSuite {

    @Test
    public void testingBeautifier() {
        String string = "beautify this String please";
        assertEquals(PoemBeautifier.beautify(string, (s) -> "ABC " + s + " ABC"), "ABC " + string + " ABC");

        assertEquals(PoemBeautifier.beautify(string, String::toUpperCase), string.toUpperCase());

        assertEquals(PoemBeautifier.beautify(string, (s) -> s.replaceAll("a", "@")), string.replaceAll("a", "@"));

        assertEquals(PoemBeautifier.beautify(string, (s) ->
                "Trebuchet is the greatest siege engine of all times.\nIt can launch a 90kg projectile over 300 meters."),
                "Trebuchet is the greatest siege engine of all times.\nIt can launch a 90kg projectile over 300 meters.");



    }
}
