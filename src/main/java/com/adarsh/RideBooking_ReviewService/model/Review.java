package com.adarsh.RideBooking_ReviewService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
public class Review extends BaseModel{

    @Column(nullable=false)
    private String content;

    private Double rating;

    @OneToOne
    private Booking booking;    //There will be review of each booking

    @Override
    public String toString(){
        return "Review: " +this.content+ " Rating: " +this.rating+ " Booking: "+booking.getId()+" "+booking.createdAt;
    }




}
