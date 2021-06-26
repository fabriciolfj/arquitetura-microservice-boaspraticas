package com.github.fabriciolfj.repository.conta.mapper;

import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.repository.conta.ContaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContaEntityMapper {

    ContaEntityMapper INSTANCE = Mappers.getMapper(ContaEntityMapper.class);

    ContaEntity toEntity(final Account account);
}
