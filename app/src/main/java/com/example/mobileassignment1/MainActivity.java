package com.example.mobileassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobileassignment1.model.IMovieDa;
import com.example.mobileassignment1.model.Movie;
import com.example.mobileassignment1.model.MovieFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText title;
    private Spinner spinner1;
    private Spinner spinner2;
    private EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.movieTitle);

        spinner1 = findViewById(R.id.spinner1);
        populateSpinner1();

        spinner2 = findViewById(R.id.spinner2);
        populateSpinner2();

        result = findViewById(R.id.result);
    }

    private void populateSpinner1(){
        MovieFactory factory = new MovieFactory();
        IMovieDa objMovie = factory.getModel();

        String[] genres = objMovie.getGenre();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, genres);

        spinner1.setAdapter(adapter);
    }
    private void populateSpinner2(){
        MovieFactory factory = new MovieFactory();
        IMovieDa objMovie = factory.getModel();

        Integer[] years = objMovie.getYear();

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, years);

        spinner2.setAdapter(adapter);
    }

    public void btnOnClick(View view){
        MovieFactory factory = new MovieFactory();
        IMovieDa objMovie = factory.getModel();



        String movieTitle = title.getText().toString();
        String movieGenre = "";
        Integer movieYear;
        movieGenre = spinner1.getSelectedItem().toString();
        movieYear = (Integer) spinner2.getSelectedItem();

        List<Movie> movies = objMovie.getMovies(movieTitle, movieGenre, movieYear);

        String str = "";
        for(Movie m : movies){
            str+= m.getTitle()+"\n";
        }
        result.setText(str);
    }
}