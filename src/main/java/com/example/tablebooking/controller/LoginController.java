package com.example.tablebooking.controller;

import com.example.tablebooking.model.dto.LoginDto;
import com.example.tablebooking.model.dto.SuccessfulLoginDto;
import com.example.tablebooking.service.LoginService;
import lombok.RequiredArgsConstructor;
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
    public SuccessfulLoginDto login(@RequestBody LoginDto loginDto) {
        return loginService.login(loginDto.getEmail(), loginDto.getPassword());
    }
}
