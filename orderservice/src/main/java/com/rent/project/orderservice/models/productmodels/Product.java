package com.rent.project.orderservice.models.productmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rent.project.orderservice.models.userprofile_models.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_details_id",nullable = false,referencedColumnName = "user_details_id")
    private UserDetails userDetails;

    @Column(name = "product_name" )
    private String productName;

    @Column(name="value_per_duration")
    private Integer value_duration;

    @Column(name="product_image")
    private String product_image;

    @Column(name="product_description")
    private String product_description;

    @Column(name="deposit")
    private Integer deposit;

    @Column(name="available_pieces")
    private Integer available_pieces;

    @Column(name="product_rate")
    private Integer product_rate;

    @ManyToOne
    //@JsonManagedReference
    @JoinColumn(name = "subcategory_id", referencedColumnName = "id")
    private SubCategory subcategory;

    @ManyToOne
    //@JsonManagedReference
    @JoinColumn(name = "productDurationRate_id", referencedColumnName = "id")
    private ProductDurationRate productDurationRates;
}
