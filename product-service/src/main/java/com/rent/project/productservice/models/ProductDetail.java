package com.rent.project.productservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product_detail")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productd_id", nullable = false)
    private Integer id;

    @Column(name = "attribute_value", nullable = false, length = 30)
    private String attributeValue;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    //@JsonManagedReference
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    //@JsonManagedReference
    @JoinColumn(name = "attribute_id", nullable = false)
    private Attribute attribute;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

}