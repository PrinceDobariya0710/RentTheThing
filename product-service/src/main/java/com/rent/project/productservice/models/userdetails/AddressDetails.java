package com.rent.project.productservice.models.userdetails;

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
@Entity(name = "AddressDetails")
@Data
@Table
public class AddressDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_details_id",nullable = false,referencedColumnName = "user_details_id")
    private UserDetails userDetails;

    @Column(nullable = false, length = 15) // name ="FlatNo",
    private String flatNo;

    @Column(nullable = false, length = 30) // name ="Street",
    private String street;

    @Column(nullable = false, length = 25) // name ="Landmark",
    private String landmark;

    @ManyToOne
    @JoinColumn(nullable = false, referencedColumnName = "city_id") //name ="City",
    private City city;

    @JoinColumn(nullable = false, referencedColumnName = "state_id") //name ="State",
    @ManyToOne
    private State state;

    @ManyToOne
    @JoinColumn(nullable = false, referencedColumnName = "country_id") //name ="CountryRef",
    private Country country;

    @Column(nullable = false, length = 8) // name = "Pincode",
    private Integer pincode;

    public AddressDetails(UserDetails userDetails, String flatNo, String street, String landmark, City city, State state, Country country, Integer pincode) {
        this.userDetails = userDetails;
        this.flatNo = flatNo;
        this.street = street;
        this.landmark = landmark;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }
}
