package com.rent.project.productservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "attribute")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "attribute_title", nullable = false, length = 30)
    private String attributeTitle;

    @Column(name = "attribute_description", nullable = false, length = 200)
    private String attributeDescription;

//    @OneToMany(mappedBy = "attribute")
//    @JsonBackReference
//    private Set<ProductDetail> productsDetail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttributeTitle() {
        return attributeTitle;
    }

    public void setAttributeTitle(String attributeTitle) {
        this.attributeTitle = attributeTitle;
    }

    public String getAttributeDescription() {
        return attributeDescription;
    }

    public void setAttributeDescription(String attributeDescription) {
        this.attributeDescription = attributeDescription;
    }
    public Attribute(){

    }
}