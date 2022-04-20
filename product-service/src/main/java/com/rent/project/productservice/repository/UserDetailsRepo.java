package com.rent.project.productservice.repository;

import com.rent.project.productservice.models.userdetails.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<UserDetails,Long> {
}
