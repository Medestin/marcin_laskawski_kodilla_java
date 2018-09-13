package com.kodilla.stream;

import com.kodilla.stream.book.*;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);

    }
}