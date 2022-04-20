package com.rent.project.orderservice.models.productmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "attribute")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Attribute implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "attribute_title", nullable = false, length = 30)
    private String attributeTitle;

    @Column(name = "attribute_description", nullable = false, length = 200)
    private String attributeDescription;

}
