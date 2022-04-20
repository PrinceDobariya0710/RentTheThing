package com.rent.project.productservice.models.userdetails;

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
    private Long city_id;

    @Column(nullable = false, unique = false, length = 25) // name = "CityName",
    private String cityName;

}
