package com.jashan.service.serviceImpl;

import com.jashan.entity.MovieShow;
import com.jashan.exception.ResourceNotFound;
import com.jashan.payload.MovieShowDto;
import com.jashan.repository.MovieShowRepository;
import com.jashan.service.MovieShowService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieShowServiceImpl implements MovieShowService {

    private MovieShowRepository movieShowRepository;

    private ModelMapper modelMapper;

    public MovieShowServiceImpl(MovieShowRepository movieShowRepository, ModelMapper modelMapper) {
        this.movieShowRepository = movieShowRepository;
        this.modelMapper = modelMapper;
    }

//    converting movie show entity in to movie show dto
    public MovieShowDto mapToDto(MovieShow movieShow){
        MovieShowDto movieShowDto = modelMapper.map(movieShow, MovieShowDto.class);
        return movieShowDto;
    }

//    converting movie show dto to movie show
    public MovieShow mapToEntity(MovieShowDto movieShowDto){
        MovieShow movieShow = modelMapper.map(movieShowDto,MovieShow.class);
        return movieShow;
    }


    @Override
    public MovieShowDto createShow(MovieShowDto movieShowDto) {

        MovieShow movieShow = mapToEntity(movieShowDto);

        MovieShow movieShow1 = movieShowRepository.save(movieShow);

        MovieShowDto movieShowDto1 = mapToDto(movieShow1);

        return movieShowDto1;
    }

    @Override
    public MovieShowDto updateShow(int id, MovieShowDto showDto) {

        MovieShow movieShow = movieShowRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("MovieShow","Id",id));

        movieShow.setLanguage(showDto.getLanguage());
        movieShow.setShowDate(showDto.getShowDate());
        movieShow.setPrice(showDto.getPrice());
        movieShow.setShow_EndTime(showDto.getShow_EndTime());
        movieShow.setShow_StartTime(showDto.getShow_StartTime());
        movieShow.setScreen_number(movieShow.getScreen_number());
        movieShow.setTheatre(movieShow.getTheatre());

        MovieShow movieShow1 = movieShowRepository.save(movieShow);

        MovieShowDto movieShowDto = mapToDto(movieShow1);
        return movieShowDto;
    }

    @Override
    public MovieShowDto getMovieShowById(int id) {

        MovieShow movieShow = movieShowRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("MovieShow","Id",id));
        MovieShowDto movieShowDto = mapToDto(movieShow);

        return movieShowDto;
    }

    @Override
    public List<MovieShowDto> getAllShows() {

        List<MovieShow> movieShows = movieShowRepository.findAll();

        List<MovieShowDto> movieShowDto = movieShows.stream().map(movieShow->
        mapToDto(movieShow)).collect(Collectors.toList());

        return movieShowDto;
    }

    @Override
    public String deleteShowById(int id) {

         movieShowRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("MovieShow","Id",id));

        return "Movie Show deleted successfully !!";
    }
}
