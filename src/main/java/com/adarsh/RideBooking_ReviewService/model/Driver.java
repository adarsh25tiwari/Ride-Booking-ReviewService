package com.adarsh.RideBooking_ReviewService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","bookings"})
public class Driver extends BaseModel{

    @Column(nullable=false)
    private String name;

    @Column(unique = true)
    private String licenceNumber;

    @Column(unique = true)
    private String mobileNumber;

    @OneToMany(mappedBy = "driver")                   // 1 driver can have many bookings
   @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings= new ArrayList<>();



}
