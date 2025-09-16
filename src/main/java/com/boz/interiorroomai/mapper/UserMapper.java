package com.boz.interiorroomai.mapper;

import com.boz.interiorroomai.dto.UserDto;
import com.boz.interiorroomai.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(UserEntity entity);
    UserEntity toEntity(UserDto dto);
}
