package com.example.studioJudo.service.account;

import com.example.studioJudo.data.dto.model.UserDto;
import com.example.studioJudo.data.dto.request.AuthenticationRequestDto;
import com.example.studioJudo.data.dto.request.ChangePasswordRequestDto;
import com.example.studioJudo.data.dto.request.RefreshRequestDto;
import com.example.studioJudo.data.dto.request.UserCreateRequestDto;
import com.example.studioJudo.data.dto.response.AuthenticationResponseDto;

public interface AccountService {

    UserDto signup(UserCreateRequestDto registerRequest);

    AuthenticationResponseDto login(AuthenticationRequestDto authenticationRequest);

    AuthenticationResponseDto refresh(RefreshRequestDto refreshRequest);

    void changePassword(ChangePasswordRequestDto changePasswordRequest);

    void logout();

}
