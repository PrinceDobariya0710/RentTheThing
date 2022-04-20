package com.rent.project.productservice.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProductDurationRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "duration")
    private String duration;

    public ProductDurationRate()
    {

    }
}
