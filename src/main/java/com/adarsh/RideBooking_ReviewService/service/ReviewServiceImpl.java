package com.adarsh.RideBooking_ReviewService.service;

import com.adarsh.RideBooking_ReviewService.api.BookingServiceApi;
import com.adarsh.RideBooking_ReviewService.dtos.TokenValidationResponseDto;
import com.adarsh.RideBooking_ReviewService.dtos.UpdateBookingResponseDto;
import com.adarsh.RideBooking_ReviewService.model.Booking;
import com.adarsh.RideBooking_ReviewService.model.BookingStatus;
import com.adarsh.RideBooking_ReviewService.model.Review;
import com.adarsh.RideBooking_ReviewService.repository.BookingRepository;
import com.adarsh.RideBooking_ReviewService.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final AuthService authService;
    private final BookingServiceApi bookingServiceApi;

    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             AuthService authService,
                             BookingServiceApi bookingServiceApi) {
        this.reviewRepository = reviewRepository;
        this.authService = authService;
        this.bookingServiceApi = bookingServiceApi;
    }

    @Override
    public Review findReviewById(Long id)  {
        return reviewRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("review-id :"+id+" not found"));
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public  boolean deleteReviewById(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("review-id :"+id+" not found"));

        if(review.getId() != null) {
            reviewRepository.delete(review);
            return true;
        }
        return false;
    }

    @Override
    public Review publishReview(Review review, String token) {
        // 1. Validate JWT through Auth Service
        TokenValidationResponseDto authResponse =
                authService.validateToken(token);

        if (authResponse == null || !Boolean.TRUE.equals(authResponse.getValid())) {
            throw new RuntimeException("Invalid token");
        }

        // 2. Only passengers can publish reviews
        if (!"ROLE_PASSENGER".equals(authResponse.getRole())) {
            throw new RuntimeException("Only passengers can publish reviews");
        }

        // 3. Get booking from Booking Service
        try {
            Response<UpdateBookingResponseDto> response =
                    bookingServiceApi
                            .getBooking(review.getBookingId())
                            .execute();

            if (!response.isSuccessful() || response.body() == null) {
                throw new RuntimeException("Booking not found");
            }

            UpdateBookingResponseDto booking = response.body();

            // 4. Check booking belongs to logged-in passenger
            if (booking.getPassenger() == null ||
                    !authResponse.getId().equals(booking.getPassenger().getId())) {

                throw new RuntimeException(
                        "You are not authorized to review this booking");
            }

            // 5. Review only completed rides
            if (booking.getBookingStatus() != BookingStatus.COMPLETED) {
                throw new RuntimeException(
                        "Review can only be submitted for completed bookings");
            }

            // 6. Save review
            return reviewRepository.save(review);

        } catch (IOException e) {
            throw new RuntimeException("Booking Service unavailable", e);
        }
    }


    @Override
    public Review updateReview(Long id, Review newReview) {
        Review review = reviewRepository.findById(id).orElseThrow(
                        ()->new EntityNotFoundException("review-id :"+id+" not found"));

        if(newReview.getContent()!=null){
            review.setContent(newReview.getContent());
        }
        if(newReview.getRating()!=null){
            review.setRating(newReview.getRating());
        }
        return reviewRepository.save(review);
    }
}
