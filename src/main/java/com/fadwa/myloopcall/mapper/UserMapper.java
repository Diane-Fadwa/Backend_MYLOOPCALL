package com.fadwa.myloopcall.mapper;

import com.fadwa.myloopcall.dto.UserDto;
import com.fadwa.myloopcall.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "token", ignore = true)
    UserDto toDto(UserEntity user);

}
