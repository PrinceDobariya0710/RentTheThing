package com.rent.project.userprofileservice.formatedData;

import com.rent.project.userprofileservice.models.City;
import com.rent.project.userprofileservice.models.Country;
import com.rent.project.userprofileservice.models.State;
import com.rent.project.userprofileservice.models.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressRequest implements Serializable {

    private UserDetails userDetailsId;

    private String flatNo;

    private String street;

    private String landmark;

    private Integer pincode;

    private City city;

    private State state;

    private Country country;
}

