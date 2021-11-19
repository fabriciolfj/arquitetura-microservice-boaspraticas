package com.github.fabriciolfj.controller.extract.model;

import com.github.fabriciolfj.entity.Extract;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExtractMapper {

    ExtractMapper INSTANCE = Mappers.getMapper(ExtractMapper.class);

    ExtractResponse toResponse(final Extract extract);
}
