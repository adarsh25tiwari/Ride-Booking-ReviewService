package com.adarsh.RideBooking_ReviewService.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerResponseDto {

    private Long id;
    private String name;
    private String phoneNumber;
}
