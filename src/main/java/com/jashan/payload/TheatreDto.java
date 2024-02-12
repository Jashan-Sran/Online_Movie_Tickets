package com.jashan.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TheatreDto {

    private int theatre_Id;

    private String theater_name;

    private String city;

    private String state;

    private int pin_code;

    private List<ScreenDto> screenDtos;
}
