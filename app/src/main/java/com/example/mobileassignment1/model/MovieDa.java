package com.example.mobileassignment1.model;

import java.util.ArrayList;
import java.util.List;

public class MovieDa implements IMovieDa {

    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieDa(){
        movies.add(new Movie("6 Underground", "Action", 2020));
        movies.add(new Movie("Baywatch", "Comedy", 2017));
        movies.add(new Movie("Man of Steel", "Action", 2013));
        movies.add(new Movie("Safe haven", "Romance", 2013));
        movies.add(new Movie("Interstellar", "Adventure", 2014));
    }

    @Override
    public List<Movie> getMovies(String title, String genre, Integer year) {
        ArrayList<Movie> data = new ArrayList<>();
        for(Movie m : movies){
            if(m.getTitle().toLowerCase().startsWith(title.toLowerCase()) || m.getGenre().equals(genre) || m.getYear() == year) {
                data.add(m);
            }
        }
        return data;
    }

    @Override
    public String[] getTitle() {
        String[] title = new String[]{"", "Man of Steel", "Baywatch", "Safe haven", "Interstellar", "6 Underground"};
        return title;
    }

    @Override
    public String[] getGenre() {
        String[] genres = new String[]{"","Comedy", "Romance", "Drama", "Action", "Horror", "Adventure", "Thriller"};
        return genres;
    }

    @Override
    public Integer[] getYear() {
        Integer[] years = new Integer[]{0000 ,2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020};
        return years;
    }
}
