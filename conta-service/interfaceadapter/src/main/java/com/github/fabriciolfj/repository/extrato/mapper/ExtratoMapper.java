package com.github.fabriciolfj.repository.extrato.mapper;

import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.repository.extrato.ExtratoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExtratoMapper {

    ExtratoMapper INSTANCE = Mappers.getMapper(ExtratoMapper.class);

    @Mapping(target = "conta", source = "codeConta")
    @Mapping(target = "dateExtrato", source = "date")
    @Mapping(target = "describe", source = "describe")
    ExtratoEntity toEntity(final Extract extrato);

    @Mapping(target = "codeConta", source = "conta")
    @Mapping(target = "debit", source = "debit")
    @Mapping(target = "credit", source = "credit")
    @Mapping(target = "balance", source = "balance")
    @Mapping(target = "date", source = "dateExtrato")
    Extract toDomain(final ExtratoEntity extratoEntity);
}
