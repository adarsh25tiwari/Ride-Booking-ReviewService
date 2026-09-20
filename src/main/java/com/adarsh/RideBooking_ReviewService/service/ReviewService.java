package com.adarsh.RideBooking_ReviewService.service;
import com.adarsh.RideBooking_ReviewService.model.Review;
import java.util.List;

public interface ReviewService {
    public Review findReviewById(Long id) throws Exception;
    public List<Review> findAllReviews();
    public boolean deleteReviewById(Long id);
    public Review publishReview(Review  review,String token) throws Exception;
    public Review updateReview(Long id,Review newReview) throws Exception;
}
