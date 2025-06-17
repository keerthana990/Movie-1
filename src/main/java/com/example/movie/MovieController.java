package com.example.movie; 
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.ArrayList;
import  com.example.movie.MovieService;
import  com.example.movie.Movie;
@RestController
public class MovieController{
    MovieService service=new MovieService();
    @GetMapping("/movies")
    public ArrayList<Movie> movies(){
        return service.movies();
    }
    @GetMapping("/movies/{movieId}")
    public Movie getByMovieId(@PathVariable("movieId")int movieID){
        return service.getByMovieId(movieID);
    }
    @PostMapping("/movies")
    public  Movie addMovie(@RequestBody Movie movie){
        return service.addMovie(movie);
    }
    @PutMapping("/movies/{movieId}")
    public  Movie updateMovie(@PathVariable("movieId")int movieID,@RequestBody Movie movie){
        return service.updateMovie(movieID, movie);
    }
    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable("movieId") int movieID){
        service.deleteMovie(movieID);
    }

}
 