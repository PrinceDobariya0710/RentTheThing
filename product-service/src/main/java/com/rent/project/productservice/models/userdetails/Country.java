package com.rent.project.productservice.models.userdetails;

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
    private Long country_id;

    @Column(nullable = false, length = 25) // name = "CountryName",
    private String countryName;
}
