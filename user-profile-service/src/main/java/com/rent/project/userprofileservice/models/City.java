package com.rent.project.userprofileservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Entity  //(name = "City")
@Data
@Table
@AllArgsConstructor
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false, length = 25) // name = "CityName",
    private String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public City(Long cityId) {
        this.id = cityId;
    }
}
