package com.boz.interiorroomai.mapper;

import com.boz.interiorroomai.dto.UserCreditDto;
import com.boz.interiorroomai.entity.UserCreditEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PlanMapper.class})
public interface UserCreditMapper {

    UserCreditDto toDto(UserCreditEntity entity);
    UserCreditEntity toEntity(UserCreditDto dto);
}
