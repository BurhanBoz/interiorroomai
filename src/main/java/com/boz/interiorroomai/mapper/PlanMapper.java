package com.boz.interiorroomai.mapper;

import com.boz.interiorroomai.dto.PlanDto;
import com.boz.interiorroomai.entity.PlanEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlanMapper {

    PlanDto toDto(PlanEntity entity);
    PlanEntity toEntity(PlanDto dto);
}
