package com.rent.project.userprofileservice.formatedData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserProfileData implements Serializable {

    private Long UserId;

    private String firstName;

    private String lastName;

    private Date dob;

    private String orgName;

    private String website;
}
