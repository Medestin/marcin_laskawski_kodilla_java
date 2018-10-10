package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Library extends Prototype {
    private static final Logger logger = Logger.getLogger(Logger.class.getName());
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        if (books.contains(book)) {
            books.remove(book);
        } else {
            logger.log(Level.WARNING, "Invalid Book");
        }
    }

    public Library shallowCopy() throws CloneNotSupportedException{
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException{
        Library clonedLibrary = (Library)super.clone();
        clonedLibrary.books = new HashSet<>();
        clonedLibrary.books.addAll(books);
        clonedLibrary.name = this.name + "Copy";

        return clonedLibrary;
    }

}