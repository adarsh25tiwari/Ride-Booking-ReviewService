package com.adarsh.RideBooking_ReviewService.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenValidationRequestDto {
    private String token;
}
