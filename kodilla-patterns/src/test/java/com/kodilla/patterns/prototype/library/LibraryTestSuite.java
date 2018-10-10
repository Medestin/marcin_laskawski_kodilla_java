package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        Book book1 = new Book("Wolf Brother", "Michelle Paver", LocalDate.of(2004, 5, 27));
        Book book2 = new Book("Spirit Walker", "Michelle Paver", LocalDate.of(2005, 5, 27));
        Book book3 = new Book("Soul Eater", "Michelle Paver", LocalDate.of(2006, 5, 27));
        Book book4 = new Book("Outcast", "Michelle Paver", LocalDate.of(2007, 5, 27));
        Book book5 = new Book("Oath Breaker", "Michelle Paver", LocalDate.of(2008, 5, 27));
        Book book6 = new Book("Ghost Hunter", "Michelle Paver", LocalDate.of(2009, 8, 20));

        Library library = new Library("Chronicles of Ancient Darkness");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);

        Library shallowLibrary = null;
        Library deepLibrary = null;

        try {
            shallowLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        try {
            deepLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        library.addBook(new Book("Winnetou", "Karl Friedrich May", LocalDate.of(1893, 6, 15)));

        System.out.println(library.getBooks());
        System.out.println(shallowLibrary.getBooks());
        System.out.println(deepLibrary.getBooks());

        Assert.assertEquals("Chronicles of Ancient DarknessCopy", deepLibrary.getName());
        Assert.assertEquals(library.getBooks().size(), shallowLibrary.getBooks().size());
        Assert.assertEquals(library.getBooks().size(), deepLibrary.getBooks().size() + 1);
    }
}
