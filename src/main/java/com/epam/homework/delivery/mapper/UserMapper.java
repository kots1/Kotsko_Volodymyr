package com.epam.homework.delivery.mapper;

import com.epam.homework.delivery.dto.UserDto;
import com.epam.homework.delivery.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userToUserDto(UserDto userDto);

    UserDto userToUserDto(User user);
}
