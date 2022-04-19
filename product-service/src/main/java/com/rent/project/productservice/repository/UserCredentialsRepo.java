package com.rent.project.productservice.repository;

import com.rent.project.productservice.models.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepo extends JpaRepository<UserCredentials,Integer> {
}
