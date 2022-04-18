package com.rent.project.userprofileservice.formatedData;

import org.springframework.beans.factory.annotation.Value;

public interface ContactInterface {

    Long getId();

    @Value("#{target.user_details_id}")
    Long getUserDetailsId();

    @Value("#{target.primary_contact}")
    Long getPrimaryContact();

    @Value("#{target.secondary_contact}")
    Long getSecondaryContact();


}
