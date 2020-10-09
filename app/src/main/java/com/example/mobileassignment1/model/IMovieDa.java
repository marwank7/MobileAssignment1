package com.example.mobileassignment1.model;

import java.util.List;

public interface IMovieDa {
    List<Movie> getMovies(String title, String genre, Integer year);

    String[] getTitle();

    String[] getGenre();

    Integer[] getYear();
}
