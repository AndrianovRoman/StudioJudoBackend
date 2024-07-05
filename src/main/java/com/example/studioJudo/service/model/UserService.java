package com.example.studioJudo.service.model;

import com.example.studioJudo.data.dto.model.RoleDto;
import com.example.studioJudo.data.dto.model.UserDto;
import com.example.studioJudo.data.dto.request.UserUpdateRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserDto> getAll();

    Page<UserDto> getAll(Pageable pageable);

    UserDto getById(Long id);

    UserDto getByEmail(String login);

    List<RoleDto> getUserRoles(Long id);

    UserDto create(UserDto userDto);

    UserDto update(UserUpdateRequestDto userDto);

    UserDto delete(Long id, Long version);

}
