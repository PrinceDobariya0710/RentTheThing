package com.rent.project.userprofileservice.formatedData;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public interface AddressInterface {

    Long getId();

    @Value("#{target.user_details_id}")
    Long getUserDetailsId();

    @Value("#{target.flat_no}")
    String getFlatNo();

    String getStreet();
    String getLandmark();

    @Value("#{target.city_name}")
    String getCityName();

    @Value("#{target.state_name}")
    String getState();

    @Value("#{target.country_name}")
    String getCountry();
    Integer getPincode();
}
