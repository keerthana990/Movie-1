package com.example.movie;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.example.movie.Movie;
import com.example.movie.MovieRepository;
import com.example.movie.MovieController;

import java.util.*;
import java.util.ArrayList;

// Do not modify the below code

public class MovieService implements MovieRepository {
    int uniqId=6;

    private static HashMap<Integer, Movie> movieList = new HashMap<>();

    public MovieService() {
        movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
        movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
        movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
        movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
        movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
    }

    // Do not modify the above code
    @Override
    public ArrayList<Movie> movies(){
        Collection<Movie> collect=movieList.values();
        ArrayList<Movie> movie=new ArrayList<>(collect);
        return movie;
    }
    @Override
    public Movie getByMovieId(int movieId){
        Movie movie= movieList.get(movieId);
        if (movie==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else 
            return movie;
    }
    @Override
    public  Movie addMovie(Movie movie){
       movie.setMovieId(uniqId);
       movieList.put(uniqId,movie);
       uniqId++;
       return movie;
    }
    @Override
    public Movie updateMovie(int movieID,Movie movie){
        Movie existingMovie=movieList.get(movieID);
        if (existingMovie==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        if (movie.getMovieName()!=null){
            existingMovie.setMovieName(movie.getMovieName());
            return existingMovie;
        }
        if (movie.getLeadActor()!=null){
            existingMovie.setLeadActor(movie.getLeadActor());
            return existingMovie;
        }
        return existingMovie;
    }
    @Override
    public void deleteMovie(int movieID){
        Movie existingMovie=movieList.get(movieID);
        if(existingMovie == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        else{
            movieList.remove(movieID);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }
}
