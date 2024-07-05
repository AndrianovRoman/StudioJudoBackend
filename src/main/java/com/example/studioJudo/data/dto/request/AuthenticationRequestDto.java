package com.example.studioJudo.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record AuthenticationRequestDto (

        @NotBlank
        String email,

        @NotBlank
        String password

) {
}
