package com.rent.project.orderservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rent.project.orderservice.models.userprofile_models.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long notificationId;

    @OneToOne
    @JoinColumn(name = "order_id",nullable = false,referencedColumnName = "order_id")
    private Orders order;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "owner_user_id",nullable = false,referencedColumnName = "user_details_id")
    private UserDetails ownerUser;
}
