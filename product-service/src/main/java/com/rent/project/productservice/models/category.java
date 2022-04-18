package com.rent.project.productservice.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name")
    private String category_name;

   /* @OneToMany(mappedBy = "cateGory")
    @JsonBackReference
    private Set<subCategory> subCategories;*/

}
