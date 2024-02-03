package com.jashan.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScreenDto {

    private int screen_number;

    private int number_of_seats;

    private String screen_name;
}
