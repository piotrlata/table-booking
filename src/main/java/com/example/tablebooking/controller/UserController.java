package com.example.tablebooking.controller;

import com.example.tablebooking.mapper.UserMapper;
import com.example.tablebooking.model.dto.UserDto;
import com.example.tablebooking.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    @PreAuthorize("isAnonymous()")
    @Operation(description = "save user")
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userMapper.daoToDto(userService.saveUser(userMapper.dtoToDao(userDto)));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated() && (@securityService.hasAccessToUser(#id) || hasAuthority('SCOPE_ADMIN'))")
    @Operation(description = "delete user", security = {@SecurityRequirement(name = "bearer")})
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated() && (@securityService.hasAccessToUser(#id) || hasAuthority('SCOPE_ADMIN'))")
    @Operation(description = "get user", security = {@SecurityRequirement(name = "bearer")})
    public UserDto getUser(@PathVariable Long id) {
        return userMapper.daoToDto(userService.getUser(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated() && (@securityService.hasAccessToUser(#id) || hasAuthority('SCOPE_ADMIN'))")
    @Operation(description = "update user", security = {@SecurityRequirement(name = "bearer")})
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
        return userMapper.daoToDto(userService.updateUser(userMapper.dtoToDao(userDto), id));
    }
}
