package com.boz.interiorroomai.mapper;


import com.boz.interiorroomai.dto.FeedbackDto;
import com.boz.interiorroomai.entity.FeedbackEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {

    FeedbackDto toDto(FeedbackEntity entity);
    FeedbackEntity toEntity(FeedbackDto dto);
}
