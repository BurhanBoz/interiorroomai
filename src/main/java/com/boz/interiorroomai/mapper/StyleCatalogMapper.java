package com.boz.interiorroomai.mapper;

import com.boz.interiorroomai.dto.StyleCatalogDto;
import com.boz.interiorroomai.entity.StyleCatalogEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StyleCatalogMapper {

    StyleCatalogDto toDto(StyleCatalogEntity entity);
    StyleCatalogEntity toEntity(StyleCatalogDto dto);
}
