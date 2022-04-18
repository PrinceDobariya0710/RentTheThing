package com.rent.project.userprofileservice.repositories;

import com.rent.project.userprofileservice.models.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactDetailsRepo extends JpaRepository<ContactDetails,Long> {

    @Override
    Optional<ContactDetails> findById(Long aLong);


    List<ContactDetails> findByuserDetailsId(Long userDetails);

//    @Transactional
//    @Modifying
//    @Query("UPDATE ContactDetails SET primaryContact =:pConatct WHERE userDetailsId =:uId")
//    Integer updateContactDetailsByNumber(@PathVariable("pConatct") Long pContact,@PathVariable("uId") Long uId);

}
