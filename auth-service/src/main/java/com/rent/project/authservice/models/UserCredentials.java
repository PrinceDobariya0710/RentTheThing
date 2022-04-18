package com.rent.project.authservice.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "user_credentials")
@Data
@AllArgsConstructor
public class UserCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "username",nullable = false, unique = false, length = 15)
    private String userName;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;


    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> role;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

}
