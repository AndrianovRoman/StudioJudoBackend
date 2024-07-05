package com.example.studioJudo.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Builder
public record UserCreateRequestDto (

        @Length(max = 100)
//        @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")
        String email,

        @NotBlank
        @Length(min = 12)
        String password,

        @NotBlank
        @Length(max = 100)
        String lastName,

        @NotBlank
        @Length(max = 100)
        String firstName,

        @Length(max = 20)
        String phoneNumber,

        Long qualificationId,

        List<Short> roles

) {
}
