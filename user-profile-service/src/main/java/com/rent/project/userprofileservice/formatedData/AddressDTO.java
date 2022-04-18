package com.rent.project.userprofileservice.formatedData;

import com.rent.project.userprofileservice.models.City;
import com.rent.project.userprofileservice.models.State;
import com.rent.project.userprofileservice.models.UserDetails;
import com.rent.project.userprofileservice.models.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class AddressDTO {

    private Long id;

    private UserDetails userDetailsId;

    private String street;

    private String flatNo;

    private String landmark;

    private City cityName;

    private State stateName;

    private Country countryName;

    private Integer pincode;


}
