package com.example.studioJudo.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Builder
public record UserUpdateRequestDto(

        @NotNull
        Long id,

        @Length(max = 100)
//        @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")
        String email,

        @NotBlank
        @Length(max = 100)
        String lastName,

        @NotBlank
        @Length(max = 100)
        String firstName,

        @Length(max = 20)
        String phoneNumber,

        Integer qualificationId,

        List<Short> roles

) {
}
