package com.github.fabriciolfj.controller.account.model;

import com.github.fabriciolfj.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);


    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "balanceInit", source = "balance")
    @Mapping(target = "extracts", ignore = true)
    Account toDomain(final AccountRequest request);

    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "account", source = "code")
    AccountResponse toResponse(final Account account);
}
