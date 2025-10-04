package com.boz.interiorroomai.mapper;

import com.boz.interiorroomai.dto.SubscriptionDto;
import com.boz.interiorroomai.entity.SubscriptionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PlanMapper.class})
public interface SubscriptionMapper {

    SubscriptionDto toDto(SubscriptionEntity entity);
    SubscriptionEntity toEntity(SubscriptionDto dto);
}
