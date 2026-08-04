package com.adarsh.RideBooking_ReviewService.repository;

import com.adarsh.RideBooking_ReviewService.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT r FROM Review r INNER JOIN r.booking b WHERE b.id = :bookingId")
    Review findReviewByBookingId(Long bookingId);

    Long countByRatingLessThanEqual(Double rating);
    List<Review> findAllByRatingLessThanEqual(Double rating);
    List<Review> findAllByRatingGreaterThanEqual(Double rating);


}
