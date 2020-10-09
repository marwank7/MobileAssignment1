package com.example.mobileassignment1.model;

public class MovieFactory {
    public IMovieDa getModel(){

        return new MovieDa();
    }
}
