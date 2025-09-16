package com.boz.interiorroomai.mapper;

import com.boz.interiorroomai.dto.JobOutputDto;
import com.boz.interiorroomai.entity.JobOutputEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobOutputMapper {

    JobOutputDto toDto(JobOutputEntity entity);
    JobOutputEntity toEntity(JobOutputDto dto);
}
