package com.github.fabriciolfj.repository.extrato.mapper;

import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.repository.extrato.ExtratoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExtratoEntityMapper {

    ExtratoEntityMapper INSTANCE = Mappers.getMapper(ExtratoEntityMapper.class);

    @Mapping(target = "conta", ignore = true)
    ExtratoEntity toEntity(final Extract extrato);
}
