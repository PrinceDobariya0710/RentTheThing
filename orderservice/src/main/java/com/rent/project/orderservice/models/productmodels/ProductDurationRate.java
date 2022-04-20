package com.rent.project.orderservice.models.productmodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDurationRate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "duration")
    private String duration;

//    @OneToMany(mappedBy = "productDurationRates")
//    //@JsonBackReference
//    private Set<product> products;

}
