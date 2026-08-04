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

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","bookings"})
public class Passenger extends BaseModel {

    @Column(nullable = false)
    private String name;

   /* @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable=false)
    private String password;
*/
    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings;
}
