package com.example.studioJudo.service.mapper.impl;

import com.example.studioJudo.data.dto.model.UserDto;
import com.example.studioJudo.data.entity.Role;
import com.example.studioJudo.data.entity.User;
import com.example.studioJudo.data.entity.Qualification;
import com.example.studioJudo.service.mapper.Mapper;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
public class UserMapper implements Mapper<UserDto, User> {

    @Override
    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .phoneNumber(user.getPhoneNumber())
                .qualificationId(nonNull(user.getQualification()) ? user.getQualification().getId() : null)
                .roles(user.getRoles().stream().map(Role::getId).toList())
                .build();
    }

    @Override
    public User toEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.id())
                .email(userDto.email())
                .password(userDto.password())
                .lastName(userDto.lastName())
                .firstName(userDto.firstName())
                .phoneNumber(userDto.phoneNumber())
                .qualification(nonNull(userDto.qualificationId()) ? Qualification.builder().id(userDto.qualificationId()).build() : null)
                .roles(userDto.roles().stream().map(role -> Role.builder().id(role).build()).toList())
                .build();
    }

}
