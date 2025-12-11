package com.fadwa.myloopcall.mapper;

import com.fadwa.myloopcall.dto.UserDTO;
import com.fadwa.myloopcall.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "token", ignore = true)
    UserDTO toDto(UserEntity user);


}
