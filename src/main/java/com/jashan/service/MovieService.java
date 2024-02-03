package com.jashan.service;

import com.jashan.payload.MovieDto;
import com.jashan.payload.MovieResponse;

import java.util.List;

public interface MovieService {

    public MovieDto createMovie(MovieDto movieDto);

    public MovieDto UpdateMovie(int id, MovieDto movieDto);

    public MovieResponse getAllMovies(int pageNo, int pageSize);

    public MovieDto getMovieById(int id);

    public String deleteMovieById(int id);

}
