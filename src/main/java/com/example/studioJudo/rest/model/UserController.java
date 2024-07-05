package com.example.studioJudo.rest.model;

import com.example.studioJudo.data.dto.model.RoleDto;
import com.example.studioJudo.data.dto.model.UserDto;
import com.example.studioJudo.data.dto.request.*;
import com.example.studioJudo.data.dto.response.AuthenticationResponseDto;
import com.example.studioJudo.service.account.AccountService;
import com.example.studioJudo.service.account.AuthorityService;
import com.example.studioJudo.service.model.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {

    UserService userService;

    AccountService accountService;

    AuthorityService authorityService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

//    @GetMapping("page")
//    public ResponseEntity<Page<UserDto>> getAll(@RequestParam("pageNumber") int pageNumber,
//                                                @RequestParam("pageSize") int pageSize) {
//        return ResponseEntity.ok(userService.getAll(PageRequest.of(pageNumber, pageSize)));
//    }

    @GetMapping("{id}/roles")
    public ResponseEntity<List<RoleDto>> getUserRoles(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUserRoles(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("login/{email}")
    public ResponseEntity<UserDto> getByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.getByEmail(email));
    }

    @GetMapping("current")
    public ResponseEntity<UserDto> getCurrent() {
        return ResponseEntity.ok(authorityService.getCurrentUser());
    }

    @PostMapping("signup")
    public ResponseEntity<UserDto> signup(@RequestBody UserCreateRequestDto request) {
        return ResponseEntity.ok(accountService.signup(request));
    }

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponseDto> login(@RequestBody AuthenticationRequestDto request) {
        return ResponseEntity.ok(accountService.login(request));
    }

    @PostMapping("refresh")
    public ResponseEntity<AuthenticationResponseDto> refresh(@RequestBody RefreshRequestDto request) {
        return ResponseEntity.ok(accountService.refresh(request));
    }

    @PostMapping("change-password")
    public ResponseEntity<Void> refresh(@RequestBody ChangePasswordRequestDto request) {
        accountService.changePassword(request);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("logout")
    public ResponseEntity<Void> logout() {
        accountService.logout();
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserUpdateRequestDto request) {
        return ResponseEntity.ok(userService.update(request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UserDto> update(@PathVariable("id") Long id,
                                          @RequestParam(value = "version", defaultValue = "1") Long version) {
        return ResponseEntity.ok(userService.delete(id, version));
    }


}
