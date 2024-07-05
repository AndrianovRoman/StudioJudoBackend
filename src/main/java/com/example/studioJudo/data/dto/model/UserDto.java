package com.example.studioJudo.data.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Builder
public record UserDto (

        @NotNull
        Long id,

        @Length(max = 100)
//        @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")
        String email,

        @JsonIgnore
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
