package com.rent.project.productservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class productDurationRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "duration")
    private String duration;

//    @OneToMany(mappedBy = "productDurationRates")
//    //@JsonBackReference
//    private Set<product> products;

    public productDurationRate()
    {

    }
}
