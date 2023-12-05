package com.example.taba42.domain;
//import com.example.taba42.dto.request.SignUpRequest;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name = "places")
@Entity
public class Place {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String placeType;

    private String placeName;

    private Long price;

    private String location;

    private String openTime;

    private Float rating;

    public Place() {
    }

    public Place(String placeType, String placeName, Long price, String location, String openTime, Float rating) {
        this.placeType = placeType;
        this.placeName = placeName;
        this.price = price;
        this.location = location;
        this.openTime = openTime;
        this.rating = rating;
    }
}
