package com.rent.project.userprofileservice.repositories;

import com.rent.project.userprofileservice.models.AddressDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressDetailsRepo extends JpaRepository<AddressDetails,Long> {
    @Override
    Optional<AddressDetails> findById(Long AddressId);

//    @Query(value = "SELECT ad.id,ad.userDetails,ad.flatNo, ad.street ,ad.landmark, cR.cityName,sR.stateName,coR.countryName,ad.pincode FROM AddressDetails ad,City cR,Country coR,State sR , UserDetails ud WHERE  ad.city = cR.id AND ad.state = sR.id AND ad.country = coR.id AND ad.userDetails =:userD")
//    List<AddressDTO> findByUserDetails(@Param("userD") Long userDetails);

//    @Query(value = "SELECT ad.id,ad.user_details_id,ad.flat_no, ad.street ,ad.landmark, cR.city_name,sR.state_name,coR.country_name,ad.pincode FROM address_details ad,city cR,country coR,state sR , user_details ud WHERE  ad.city_id = cR.id AND ad.state_id = sR.id AND ad.country_id = coR.id AND ad.user_details_id = ud.id AND ad.user_details_id=?;",nativeQuery = true)
//    AddressDTO findByUserDetails(Long userDetails);

    @Query(value = "SELECT * FROM address_details  WHERE user_details_id =:u",nativeQuery = true)
    List<AddressDetails> findByUserDetails(@Param("u") Long userDetails);


}
