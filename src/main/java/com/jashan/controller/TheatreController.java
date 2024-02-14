package com.jashan.controller;

import com.jashan.entity.Theatre;
import com.jashan.payload.TheatreDto;
import com.jashan.service.TheatreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    private TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping("/create")
    public ResponseEntity<TheatreDto> createTheatre(@RequestBody TheatreDto theatreDto){

        TheatreDto theatreDto1 = theatreService.createTheatre(theatreDto);
        return new ResponseEntity<>(theatreDto1, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TheatreDto> updateTheatre(@PathVariable int id, @RequestBody TheatreDto theatreDto){

        TheatreDto theatreDto1 = theatreService.updateTheatre(id,theatreDto);

        return ResponseEntity.ok(theatreDto1);
    }

    @GetMapping("/")
    public ResponseEntity<List<TheatreDto>> getAllTheatres(){

        List<TheatreDto> theatre = theatreService.getAllTheatres();

        return new ResponseEntity<>(theatre,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheatreDto> getById(@PathVariable int id){

        TheatreDto theatreDto = theatreService.getTheatreById(id);

        return new ResponseEntity<>(theatreDto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTheatre(@PathVariable int id){

        theatreService.deleteTheatreById(id);

        return new ResponseEntity<>("Theatre deleted successfully with id " + id, HttpStatus.OK);
    }

}
