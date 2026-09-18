package com.adarsh.RideBooking_ReviewService.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenValidationResponseDto {
    private Boolean valid;
    private String email;
    private String role;

}
