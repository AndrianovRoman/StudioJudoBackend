package com.example.studioJudo.service.initialization.impl;

import com.example.studioJudo.data.dto.model.RoleDto;
import com.example.studioJudo.data.entity.Role;
import com.example.studioJudo.data.entity.User;
import com.example.studioJudo.data.enumeration.RoleName;
import com.example.studioJudo.service.initialization.InitializationService;
import com.example.studioJudo.repositories.model.UserRepository;
import com.example.studioJudo.service.mapper.Mapper;
import com.example.studioJudo.service.model.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class InitializationServiceImpl implements InitializationService {

    @NonFinal
    @Value("${admin.login}")
    String login;

    @NonFinal
    @Value("${admin.email}")
    String email;

    @NonFinal
    @Value("${admin.password}")
    String password;

    PasswordEncoder passwordEncoder;

    UserRepository userRepository;

    RoleService roleService;

    Mapper<RoleDto, Role> roleMapper;

    @Override
    public void createAdmin() {
        if (userRepository.existsByEmail(login)) {
            return;
        }
        userRepository.save(User.builder()
                .email(login)
                .password(passwordEncoder.encode(password))
                .lastName(login)
                .firstName(login)
                .roles(List.of(roleMapper.toEntity(roleService.getByName(RoleName.ADMIN))))
                .build());
    }

}
