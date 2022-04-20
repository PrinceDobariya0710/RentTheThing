package com.rent.project.productservice.models.userdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity //(name = "states")
@Table
@AllArgsConstructor
public class State implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long state_id;

    @Column( nullable = false, length = 25) //name = "StateName",
    private String stateName;
}
