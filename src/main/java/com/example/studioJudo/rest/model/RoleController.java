package com.example.studioJudo.rest.model;

import com.example.studioJudo.data.dto.model.RoleDto;
import com.example.studioJudo.service.model.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("api/roles")
public class RoleController {

    RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleDto>> getRoles() {
        return ResponseEntity.ok(roleService.getAll());
    }

}
