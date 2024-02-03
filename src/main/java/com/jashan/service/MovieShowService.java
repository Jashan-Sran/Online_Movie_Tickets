package com.jashan.service;

import com.jashan.entity.MovieShow;
import com.jashan.payload.MovieShowDto;

import java.util.List;

public interface MovieShowService {

    public MovieShowDto createShow(MovieShowDto movieShowDto);

    public MovieShowDto updateShow(int id, MovieShowDto movieShowDto);

    public MovieShowDto getMovieShowById(int id);

    public List<MovieShowDto> getAllShows();

    public String deleteShowById(int id);


}
