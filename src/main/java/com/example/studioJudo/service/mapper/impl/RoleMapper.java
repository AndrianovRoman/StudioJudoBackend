package com.example.studioJudo.service.mapper.impl;

import com.example.studioJudo.data.dto.model.RoleDto;
import com.example.studioJudo.data.entity.Role;
import com.example.studioJudo.service.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper implements Mapper<RoleDto, Role> {

    @Override
    public RoleDto toDto(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    @Override
    public Role toEntity(RoleDto roleDto) {
        return Role.builder()
                .id(roleDto.id())
                .name(roleDto.name())
                .build();
    }

}