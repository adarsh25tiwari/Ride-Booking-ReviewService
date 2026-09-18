package com.adarsh.RideBooking_ReviewService.api;

import com.adarsh.RideBooking_ReviewService.dtos.UpdateBookingResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BookingServiceApi {
    @GET("/api/v1/booking/{bookingId}")
    Call<UpdateBookingResponseDto> getBooking(@Path("bookingId") Long bookingId
    );
}
