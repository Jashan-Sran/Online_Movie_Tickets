package com.jashan.service.serviceImpl;

import com.jashan.entity.Theatre;
import com.jashan.exception.ResourceNotFound;
import com.jashan.payload.TheatreDto;
import com.jashan.repository.TheatreRepository;
import com.jashan.service.TheatreService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImpl implements TheatreService {

    private ModelMapper modelMapper;

    private TheatreRepository theatreRepository;

    public TheatreServiceImpl(ModelMapper modelMapper, TheatreRepository theatreRepository) {
        this.modelMapper = modelMapper;
        this.theatreRepository = theatreRepository;
    }


//    converting entity to dto

    public TheatreDto mapToDto(Theatre theatre){
        TheatreDto theatreDto =  modelMapper.map(theatre, TheatreDto.class);
        return theatreDto;
    }

//    converting Dto to Entity

    public Theatre mapToEntity(TheatreDto theatreDto){
        Theatre theatre = modelMapper.map(theatreDto, Theatre.class);
        return theatre;
    }

    @Override
    public TheatreDto createTheatre(TheatreDto theatreDto) {

        Theatre theatre = mapToEntity(theatreDto);

       Theatre theatre1 = theatreRepository.save(theatre);

       return mapToDto(theatre1);

    }

    @Override
    public TheatreDto updateTheatre(int id, TheatreDto theatreDto) {

        Theatre theatre = theatreRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Theatre", "id",id));

        theatre.setTheater_name(theatreDto.getTheater_name());
        theatre.setCity(theatreDto.getCity());
        theatre.setPin_code(theatreDto.getPin_code());
        theatre.setState(theatreDto.getState());

        Theatre theatre1 = theatreRepository.save(theatre);
        TheatreDto theatreDto1 = mapToDto(theatre1);
        return theatreDto1;
    }

    @Override
    public List<TheatreDto> getAllTheatres() {

        List<Theatre> theatre = theatreRepository.findAll();

        List<TheatreDto> theatreDto = theatre.stream().map(theatre1 ->
                mapToDto(theatre1)).collect(Collectors.toList());

        return  theatreDto;

    }

    @Override
    public TheatreDto getTheatreById(int id) {

        Theatre theatre = theatreRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Theatre", "Id",id));

        TheatreDto theatreDto = mapToDto(theatre);

        return theatreDto;
    }

    @Override
    public String deleteTheatreById(int id) {

        theatreRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Theatre", "Id",id));

        return "Theatre deleted successfully with id " + id;
    }
}
