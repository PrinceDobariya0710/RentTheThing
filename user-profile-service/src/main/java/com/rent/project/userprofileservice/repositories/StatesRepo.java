package com.rent.project.userprofileservice.repositories;

import com.rent.project.userprofileservice.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatesRepo extends JpaRepository<State,Long> {
    @Override
    Optional<State> findById(Long StateId);

    State findBystateName(String name);

}
