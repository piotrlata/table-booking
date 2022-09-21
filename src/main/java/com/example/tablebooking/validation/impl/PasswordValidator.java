package com.example.tablebooking.validation.impl;

import com.example.tablebooking.model.dto.UserDto;
import com.example.tablebooking.validation.PasswordValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValid, UserDto> {
    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext constraintValidatorContext) {
        return userDto.getPassword().equals(userDto.getConfirmedPassword());
    }
}
