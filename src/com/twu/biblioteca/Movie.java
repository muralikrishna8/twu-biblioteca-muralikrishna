package com.twu.biblioteca;

public class Movie implements LibraryItem {

    private String name;
    private int year;
    private String director;
    private String rating;

    public Movie(String name, int year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public boolean matchTitle(String name){
        return this.name.equals(name);
    }

    @Override
    public String toString(){
        return String.format("%s | %d | %s | %s", name, year, director, rating);
    }
}
