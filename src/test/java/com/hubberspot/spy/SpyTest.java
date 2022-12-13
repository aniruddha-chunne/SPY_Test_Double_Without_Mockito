package com.hubberspot.spy;

import org.junit.jupiter.api.Test;
import com.hubberspot.spy.*;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpyTest
{
    @Test
    public void demoSpy()
    {
        BookRepositorySpy bookRepositoryspy = new BookRepositorySpy();
        BookService bookService = new BookService(bookRepositoryspy);

        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("12345", "Junit5 in Action", 400, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);


        assertEquals(2, bookRepositoryspy.timesCalled());
        assertTrue(bookRepositoryspy.calledWith(book2));


    }
}
