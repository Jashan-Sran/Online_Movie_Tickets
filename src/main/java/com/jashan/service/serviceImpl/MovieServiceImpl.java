package com.jashan.service.serviceImpl;

import com.jashan.entity.Movie;
import com.jashan.exception.ResourceNotFound;
import com.jashan.payload.MovieDto;
import com.jashan.payload.MovieResponse;
import com.jashan.repository.MovieRepository;
import com.jashan.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    private ModelMapper modelMapper;


    public MovieServiceImpl(MovieRepository movieRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

//    convert movie entity to movie Dto

    private MovieDto mapToDto(Movie movie){

        MovieDto movieDto = modelMapper.map(movie,MovieDto.class);
        return movieDto;
    }

//    convert Movie Dto to Movie Entity

    public Movie mapToEntity(MovieDto movieDto){
        Movie movie = modelMapper.map(movieDto,Movie.class);
        return movie;
    }

    @Override
    public MovieDto createMovie(MovieDto movieDto) {

     Movie movie = mapToEntity(movieDto);

     Movie movie1 = movieRepository.save(movie);

     MovieDto movieDto1 = mapToDto(movie1);

        return movieDto1;
    }

    @Override
    public MovieDto UpdateMovie(int id, MovieDto movieDto) {

    Movie movie = movieRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Movie","id",id));

    movie.setMovie_title(movieDto.getMovie_title());
    movie.setMovie_description(movieDto.getMovie_description());
    movie.setMovie_stars(movieDto.getMovie_stars());

        return mapToDto(movie);

    }

    @Override
    public MovieResponse getAllMovies(int pageNo, int pageSize) {

// create pageable instance
        Pageable pageable = PageRequest.of(pageNo,pageSize);


//   use findAll method from pageable interface
        Page<Movie> movies = movieRepository.findAll(pageable);

//        get content for page object
        List<Movie> listOfMovies = movies.getContent();

       List<MovieDto> content =   listOfMovies.stream().map(movie1
                -> mapToDto(movie1)).collect(Collectors.toList());

       MovieResponse movieResponse = new MovieResponse();
       movieResponse.setContent(content);
       movieResponse.setPageNo(movies.getNumber());
       movieResponse.setPageSize(movies.getSize());
       movieResponse.setTotalPages(movies.getTotalPages());
       movieResponse.setTotalElements(movies.getTotalElements());
       movieResponse.setLast(movies.isLast());

       return movieResponse;

    }

    @Override
    public MovieDto getMovieById(int id) {

        Movie movie = movieRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Movie","id",id));
        MovieDto movieDto = mapToDto(movie);
        return movieDto;
    }

    @Override
    public String deleteMovieById(int id) {
       movieRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Movie","id",id));
        movieRepository.deleteById(id);

        return "movie deleted successfully with id " + id;
    }
}
