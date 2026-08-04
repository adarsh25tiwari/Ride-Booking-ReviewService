package com.adarsh.RideBooking_ReviewService.repository;

import com.adarsh.RideBooking_ReviewService.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

}
