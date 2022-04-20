package com.rent.project.orderservice.models.productmodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "sub_category")
public class SubCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "subCategory_name")
    private String subCategory_name;

    @ManyToOne
    //@JsonManagedReference
    @JoinColumn(name = "category_id",nullable = false,referencedColumnName = "id")
    private  Category cateGory;

//    @OneToMany(mappedBy = "subcategory")
//   // @JsonBackReference
//    private Set<product> products;

}
