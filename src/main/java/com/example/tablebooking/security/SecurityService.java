package com.example.tablebooking.security;

import com.example.tablebooking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class SecurityService {
    private final UserService userService;

    public boolean hasAccessToUser(Long userId) {
        try {
            return userService.getCurrentUser().getId().equals(userId);
        } catch (EntityNotFoundException e) {
            return false;
        }
    }
}
