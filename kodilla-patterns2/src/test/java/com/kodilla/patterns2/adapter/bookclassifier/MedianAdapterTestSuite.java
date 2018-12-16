package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest(){
        Book book1 = new Book("Jam Lasica", "No... Jam Lasica", 2000, "1234567890");
        Book book2 = new Book("Jam Lasica", "No... Jam Lasica", 2010, "5165156156");
        Book book3 = new Book("Jam Lasica", "No... Jam Lasica", 1995, "5165484518");
        Book book4 = new Book("Jam Lasica", "No... Jam Lasica", 2007, "1559454987");
        Book book5 = new Book("Jam Lasica", "No... Jam Lasica", 2015, "5165161847");

        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        MedianAdapter medianAdapter = new MedianAdapter();
        int median = medianAdapter.publicationYearMedian(books);
        assertEquals(2007, median);
    }
}