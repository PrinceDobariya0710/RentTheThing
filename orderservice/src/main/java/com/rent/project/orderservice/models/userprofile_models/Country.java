package com.rent.project.orderservice.models.userprofile_models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@NoArgsConstructor
@Entity//(name = "country")
@Data
@Table
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long countryId;

    @Column(nullable = false, length = 25) // name = "CountryName",
    private String countryName;
}
