package com.github.fabriciolfj.repository.conta.mapper;

import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.repository.conta.ContaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContaMapper {

    ContaMapper INSTANCE = Mappers.getMapper(ContaMapper.class);

    ContaEntity toEntity(final Account account);

    @Mapping(target = "code", source = "code")
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "balanceInit", ignore = true)
    @Mapping(target = "product", ignore = true)
    Account toDomain(final ContaEntity contaEntity);
}
