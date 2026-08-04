package com.adarsh.RideBooking_ReviewService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="booking_review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{

    @Column(nullable=false)
    private String content;

    private Double rating;

    //There will be review of each booking & we don't want whenever we fetch review all booking details to be fetch
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(nullable=false)
    private Booking booking;

    @Override
    public String toString(){
        return "Review: " +this.content+ " Rating: " +this.rating+ " Booking: "+booking.getId()+" "+booking.createdAt;
    }




}
