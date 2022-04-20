package com.rent.project.authservice.repository;

import com.rent.project.authservice.models.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface User_Credentials_Repository extends JpaRepository<UserCredentials,Long> {
    @Query(value = "SELECT * from user_credentials WHERE username = ?1",nativeQuery = true)
    UserCredentials findByUserName(String userName);

    @Query(value = "select * from user_credentials where email = ?1",nativeQuery = true)
    UserCredentials findByEmail(String email);

    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
}
