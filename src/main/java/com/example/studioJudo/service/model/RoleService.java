package com.example.studioJudo.service.model;

import com.example.studioJudo.data.dto.model.RoleDto;
import com.example.studioJudo.data.enumeration.RoleName;

import java.util.List;

public interface RoleService {
    List<RoleDto> getAll();

    RoleDto getByName(RoleName name);

    List<RoleDto> getByIds(List<Short> ids);

    List<RoleName> getNamesByIds(List<Short> ids);
}
