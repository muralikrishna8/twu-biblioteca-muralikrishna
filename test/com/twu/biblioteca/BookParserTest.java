package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BookParserTest {

    @Test
    public void shouldReturnBookObjectWhenBookTitleIsGiven() {
        BookParser bookParser = new BookParser();

        Book actualBook = bookParser.getBook("Book1");

        assertThat(actualBook, is(new Book("Book1", "", 0)));
    }

}