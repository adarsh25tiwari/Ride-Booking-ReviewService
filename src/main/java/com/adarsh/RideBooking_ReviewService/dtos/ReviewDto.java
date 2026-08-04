package com.adarsh.RideBooking_ReviewService.dtos;

import com.adarsh.RideBooking_ReviewService.model.Review;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {
    private Long reviewId;
    private String content;
    private Double rating;
    private Long BookingId;
    private Date createdAt;
    private Date updatedAt;
}
