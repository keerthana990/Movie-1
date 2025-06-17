package com.example.movie;
import java.util.*;
import java.util.ArrayList;
import  com.example.movie.MovieService;
import  com.example.movie.Movie;
public interface MovieRepository{
    ArrayList<Movie> movies();
    Movie getByMovieId(int movieID);
    Movie addMovie(Movie movie);
    Movie updateMovie(int movieID,Movie movie);
    void deleteMovie(int movieID);
}