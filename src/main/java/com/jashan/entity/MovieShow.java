package com.jashan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class MovieShow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;

    private int show_StartTime;

    private int show_EndTime;

    private Date showDate;

    private String language;

    private double price;

    private int screen_number;

        @OneToOne(cascade = CascadeType.ALL)
        private Theatre theatre;



}
