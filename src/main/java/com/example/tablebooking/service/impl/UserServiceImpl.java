package com.example.tablebooking.service.impl;

import com.example.tablebooking.model.dao.User;
import com.example.tablebooking.repository.RoleRepository;
import com.example.tablebooking.repository.UserRepository;
import com.example.tablebooking.security.SecurityUtils;
import com.example.tablebooking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        roleRepository.findByName("USER").ifPresent(role -> user.setRoles(Collections.singletonList(role)));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public User updateUser(User user, Long id) {
        var userDb = getUser(id);
        userDb.setFirstName(user.getFirstName());
        userDb.setLastName(user.getLastName());
        userDb.setEmail(user.getEmail());
        return userDb;
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User getCurrentUser() {
        return userRepository.findByEmail(SecurityUtils.getCurrentUserEmail())
                .orElseThrow(EntityNotFoundException::new);
    }
}