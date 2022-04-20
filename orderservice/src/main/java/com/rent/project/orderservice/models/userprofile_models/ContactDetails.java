package com.rent.project.orderservice.models.userprofile_models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table//(name = "contact_details")
public class ContactDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactDetailsId;

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_details_id",nullable = false,referencedColumnName = "user_details_id")//name = "UserDetailsId"
    private UserDetails userDetails;

    @Column(nullable = false, length = 10)// name = "PrimaryContact",
    private Long primaryContact;

    @Column(nullable = true, length = 10) // name = "SecondaryContact",
    private Long secondaryContact;

    public ContactDetails(UserDetails userDetails, Long primaryContact, Long secondaryContact) {
        this.userDetails = userDetails;
        this.primaryContact = primaryContact;
        this.secondaryContact = secondaryContact;
    }
}
