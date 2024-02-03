package com.jashan.controller;

import com.jashan.payload.MovieDto;
import com.jashan.payload.MovieResponse;
import com.jashan.service.serviceImpl.MovieServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieServiceImpl movieService;

    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/create")
    public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto){
        MovieDto movieDto1 = movieService.createMovie(movieDto);
        return new ResponseEntity<>(movieDto1, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable int id, @RequestBody MovieDto movieDto){

        MovieDto movieDto1 = movieService.UpdateMovie(id,movieDto);

        return new ResponseEntity<>(movieDto1, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable int id){
        MovieDto movieDto = movieService.getMovieById(id);
        return new ResponseEntity<>(movieDto,HttpStatus.OK);
    }

    @GetMapping("/getAllMovies")
    public MovieResponse getAllMovies
            (@RequestParam(value = "pageNo",defaultValue = "0",required = false)int pageNo,
             @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize)
            {
               return movieService.getAllMovies(pageNo,pageSize);
    }

    @DeleteMapping("/{id}")
    public String deleteMovieById(@PathVariable int id){
        movieService.deleteMovieById(id);
        return "Movie deleted successfully with id " + id;
    }

}
