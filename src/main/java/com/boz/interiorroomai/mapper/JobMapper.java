package com.boz.interiorroomai.mapper;

import com.boz.interiorroomai.dto.JobDto;
import com.boz.interiorroomai.entity.JobEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobMapper {

    JobDto toDto(JobEntity entity);
    JobEntity toEntity(JobDto dto);
}
