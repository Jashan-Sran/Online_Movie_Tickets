package com.jashan.controller;

import com.jashan.payload.MovieShowDto;
import com.jashan.service.serviceImpl.MovieShowServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieShow")
public class MovieShowController {

    private MovieShowServiceImpl movieShowService;

    public MovieShowController(MovieShowServiceImpl movieShowService) {
        this.movieShowService = movieShowService;
    }

    @PostMapping("/create")
    public ResponseEntity<MovieShowDto> createMovie(@RequestBody MovieShowDto movieShowDto){
        MovieShowDto movieShowDto1 = movieShowService.createShow(movieShowDto);
        return new ResponseEntity<>(movieShowDto1, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MovieShowDto> updateMovie(@PathVariable int id, @RequestBody MovieShowDto movieShowDto){
         MovieShowDto movieShowDto1 = movieShowService.updateShow(id, movieShowDto);
         return new ResponseEntity<>(movieShowDto1,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovieShow(@PathVariable int id){

        movieShowService.deleteShowById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieShowDto> getMovieById(@PathVariable int id){
        MovieShowDto movieShowDto = movieShowService.getMovieShowById(id);
        return new ResponseEntity<MovieShowDto>(movieShowDto,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<MovieShowDto>> getAllMovies(){
        List<MovieShowDto> movieDtos = movieShowService.getAllShows();
        return new ResponseEntity<>(movieDtos,HttpStatus.OK);
    }

}
