package com.example.tablebooking.mapper;

import com.example.tablebooking.model.dao.User;
import com.example.tablebooking.model.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User dtoToDao(UserDto userDto);

    UserDto daoToDto(User user);
}
