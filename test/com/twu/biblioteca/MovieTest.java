package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void shouldGiveTheMovieDetails() {
        Movie movie = new Movie("3 idiots", 2009, "Rajkumar Hirani", "9");

        String actualBook = String.format("%20s %-20s | %-6d | %-20s | %-6s", " ","3 idiots", 2009, "Rajkumar Hirani", "9");

        assertEquals(actualBook, movie.toString());
    }

    @Test
    public void shouldGiveWhetherItsTitleMatchesWhenQueried() {
        Movie movie = new Movie("3 idiots", 2009, "Rajkumar Hirani", "9");

        boolean actual = movie.matchTitle("3 idiots");

        assertTrue(actual);
    }
}