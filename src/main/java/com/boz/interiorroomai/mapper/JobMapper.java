package com.boz.interiorroomai.mapper;

import com.boz.interiorroomai.dto.JobDto;
import com.boz.interiorroomai.entity.JobEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PlanMapper.class, StyleCatalogMapper.class})
public interface JobMapper {

    JobDto toDto(JobEntity entity);
    JobEntity toEntity(JobDto dto);
}
