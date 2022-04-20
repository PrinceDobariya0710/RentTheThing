package com.rent.project.orderservice.models.userprofile_models;

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
    @Column(name = "state_id")
    private Long stateId;

    @Column( nullable = false, length = 25) //name = "StateName",
    private String stateName;
}
