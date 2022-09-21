package com.example.tablebooking.service;

import com.example.tablebooking.model.dao.User;

public interface UserService {
    User saveUser(User user);

    void deleteUser(Long id);

    User updateUser(User user, Long id);

    User getUser(Long id);

    User getCurrentUser();
}
