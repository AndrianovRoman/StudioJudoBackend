package com.example.studioJudo.service.account.impl;

import com.example.studioJudo.data.dto.model.UserDto;
import com.example.studioJudo.data.entity.User;
import com.example.studioJudo.data.enumeration.RoleName;
import com.example.studioJudo.exception.NoAuthorityException;
import com.example.studioJudo.service.account.AuthorityService;
import com.example.studioJudo.service.mapper.Mapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    Mapper<UserDto, User> userMapper;

    @Override
    public UserDto getCurrentUser() {
        return userMapper.toDto((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    @Override
    public boolean hasAnyAuthority(List<RoleName> roles) {
        List<String> roleNames = roles.stream().map(RoleName::name).toList();
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .anyMatch(authority -> roleNames.contains(authority.getAuthority()));
    }

    @Override
    public void checkRolesAndThrow(List<RoleName> roles) {
        if (!hasAnyAuthority(roles)) {
            throw new NoAuthorityException();
        }
    }

}
