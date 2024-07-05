package com.example.studioJudo.data.dto.response;

import lombok.Builder;

@Builder
public record AuthenticationResponseDto (

        String token,

        String refreshToken

){
}
