package com.jashan.service;

import com.jashan.entity.Theatre;
import com.jashan.payload.TheatreDto;

import java.util.List;

public interface TheatreService {

    public TheatreDto createTheatre(TheatreDto theatreDto);

    public TheatreDto updateTheatre(int id, TheatreDto theatreDto);

    public List<TheatreDto> getAllTheatres();

    public TheatreDto getTheatreById(int id);

    public String deleteTheatreById(int id);
}
