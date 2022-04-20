package com.rent.project.orderservice.models.productmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.rent.project.orderservice.models.productmodels.*;
import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "product_detail")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productd_id", nullable = false)
    private Integer id;

    @Column(name = "attribute_value", nullable = false, length = 30)
    private String attributeValue;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    //@JsonManagedReference
    @JoinColumn(name = "attribute_id", nullable = false)
    private Attribute attribute;

}
