package com.github.fabriciolfj.controller.model;

import com.github.fabriciolfj.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account toDomain(final AccountRequest request);
}
