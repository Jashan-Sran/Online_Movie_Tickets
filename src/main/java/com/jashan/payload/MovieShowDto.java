package com.jashan.payload;

import com.jashan.entity.Theatre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieShowDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;

    private int show_StartTime;

    private int show_EndTime;

    private Date showDate;

    private String language;

    private double price;

    private int screen_number;

    @ManyToOne(cascade = CascadeType.ALL)
    private int movie_id;

    @OneToOne(cascade = CascadeType.ALL)
    private Theatre theatre;

}
