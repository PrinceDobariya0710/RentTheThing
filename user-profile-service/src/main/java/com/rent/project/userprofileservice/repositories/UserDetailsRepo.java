package com.rent.project.userprofileservice.repositories;

import com.rent.project.userprofileservice.models.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepo extends JpaRepository<UserDetails,Long> {

    @Override
    Optional<UserDetails> findById(Long UserDetailsId);

}
