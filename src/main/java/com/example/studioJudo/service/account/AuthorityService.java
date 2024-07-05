package com.example.studioJudo.service.account;

import com.example.studioJudo.data.dto.model.UserDto;
import com.example.studioJudo.data.enumeration.RoleName;

import java.util.List;

public interface AuthorityService {

    UserDto getCurrentUser();

    boolean hasAnyAuthority(List<RoleName> roles);

    void checkRolesAndThrow(List<RoleName> roles);

}
