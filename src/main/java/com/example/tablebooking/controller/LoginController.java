package com.example.tablebooking.controller;

import com.example.tablebooking.model.dto.LoginDto;
import com.example.tablebooking.model.dto.SuccessfulLoginDto;
import com.example.tablebooking.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {
    private final LoginService loginService;

    @PostMapping
    @PreAuthorize("isAnonymous()")
    @Operation(description = "log in with email and password")
    public SuccessfulLoginDto login(@RequestBody LoginDto loginDto) {
        return loginService.login(loginDto.getEmail(), loginDto.getPassword());
    }
}
