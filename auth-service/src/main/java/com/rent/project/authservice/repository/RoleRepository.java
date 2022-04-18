package com.rent.project.authservice.repository;

import com.rent.project.authservice.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<UserRole,Long> {
    Optional<UserRole> findById(Long role);
}
