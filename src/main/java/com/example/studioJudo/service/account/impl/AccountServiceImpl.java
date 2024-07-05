package com.example.studioJudo.service.account.impl;

import com.example.studioJudo.data.dto.model.UserDto;
import com.example.studioJudo.data.dto.request.AuthenticationRequestDto;
import com.example.studioJudo.data.dto.request.ChangePasswordRequestDto;
import com.example.studioJudo.data.dto.request.RefreshRequestDto;
import com.example.studioJudo.data.dto.request.UserCreateRequestDto;
import com.example.studioJudo.data.dto.response.AuthenticationResponseDto;
import com.example.studioJudo.data.entity.RefreshToken;
import com.example.studioJudo.data.entity.User;
import com.example.studioJudo.repositories.model.RefreshTokenRepository;
import com.example.studioJudo.repositories.model.UserRepository;
import com.example.studioJudo.service.account.AccountService;
import com.example.studioJudo.service.account.AuthorityService;
import com.example.studioJudo.service.account.JwtService;
import com.example.studioJudo.service.mapper.impl.UserMapper;
import com.example.studioJudo.service.model.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    PasswordEncoder passwordEncoder;

    UserService userService;

    UserRepository userRepository;

    AuthenticationManager authenticationManager;

    JwtService jwtService;

    RefreshTokenRepository refreshTokenRepository;

    AuthorityService authorityService;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserDto signup(UserCreateRequestDto registerRequest) {
        return userService.create(UserDto.builder()
                .password(passwordEncoder.encode(registerRequest.password()))
                .lastName(registerRequest.lastName())
                .firstName(registerRequest.firstName())
                .email(registerRequest.email())
                .phoneNumber(registerRequest.phoneNumber())
                .qualificationId(registerRequest.qualificationId())
                .roles(registerRequest.roles())
                .build());
    }

    @Override
    @Transactional
    public AuthenticationResponseDto login(AuthenticationRequestDto authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.email(), authenticationRequest.password())
        );
        var user = userRepository.findByEmailWithRoles(authenticationRequest.email())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return login(user);
    }

    @Override
    @Transactional
    public AuthenticationResponseDto refresh(RefreshRequestDto refreshRequest) {
        var userId = Long.parseLong(jwtService.extractRefreshUserId(refreshRequest.refreshToken()));
        if (!refreshTokenRepository.existsByTokenAndUserId(refreshRequest.refreshToken(), userId)) {
            throw new UsernameNotFoundException("Refresh token not found");
        }
        var user = userRepository.findByIdWithRoles(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return login(user);
    }

    @Override
    @Transactional
    public void changePassword(ChangePasswordRequestDto changePasswordRequest) {
        var user = userRepository.findById(authorityService.getCurrentUser().id())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (!passwordEncoder.matches(changePasswordRequest.oldPassword(), user.getPassword())) {
            throw new BadCredentialsException("Old password does not match");
        }
        user.setPassword(passwordEncoder.encode(changePasswordRequest.newPassword()));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void logout() {
        Optional.ofNullable(authorityService.getCurrentUser())
                .ifPresent(user -> refreshTokenRepository.deleteByUserId(user.id()));
    }

    private AuthenticationResponseDto login(User user) {
        refreshTokenRepository.deleteByUserId(user.getId());
        return AuthenticationResponseDto.builder()
                .token(jwtService.generateToken(user))
                .refreshToken(refreshTokenRepository.save(RefreshToken.builder()
                        .user(user)
                        .token(jwtService.generateRefreshToken(String.valueOf(user.getId())))
                        .build()).getToken())
                .build();
    }
}
