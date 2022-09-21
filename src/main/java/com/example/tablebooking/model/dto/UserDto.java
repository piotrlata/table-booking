package com.example.tablebooking.model.dto;

import com.example.tablebooking.validation.PasswordValid;
import com.example.tablebooking.validation.group.CreateUser;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@PasswordValid(groups = CreateUser.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank(groups = CreateUser.class)
    private String password;
    @NotBlank(groups = CreateUser.class)
    private String confirmedPassword;
}


