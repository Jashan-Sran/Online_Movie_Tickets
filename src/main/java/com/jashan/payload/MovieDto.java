package com.jashan.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private int movie_Id;

    private String movie_title;

    private String movie_description;

    private String movie_stars;

    private List<MovieShowDto> movieShow;

}
