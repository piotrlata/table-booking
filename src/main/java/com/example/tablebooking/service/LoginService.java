package com.example.tablebooking.service;

import com.example.tablebooking.model.dto.SuccessfulLoginDto;

public interface LoginService {
    SuccessfulLoginDto login(String email, String password);
}
