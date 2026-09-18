package com.adarsh.RideBooking_ReviewService.dtos;

import com.adarsh.RideBooking_ReviewService.model.BookingStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBookingResponseDto {
    private Long bookingId;
    private BookingStatus bookingStatus;
    private DriverResponseDto driver;
    private PassengerResponseDto passenger;
}
