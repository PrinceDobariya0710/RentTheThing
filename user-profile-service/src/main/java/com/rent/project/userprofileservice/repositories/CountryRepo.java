package com.rent.project.userprofileservice.repositories;

import com.rent.project.userprofileservice.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepo extends JpaRepository<Country,Long> {
    @Override
    Optional<Country> findById(Long CountryId);
}
