package com.rent.project.userprofileservice.repositories;

import com.rent.project.userprofileservice.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepo extends JpaRepository<City,Long> {
    @Override
    Optional<City> findById(Long cityId);

    @Override
    boolean existsById(Long cityId);

}
