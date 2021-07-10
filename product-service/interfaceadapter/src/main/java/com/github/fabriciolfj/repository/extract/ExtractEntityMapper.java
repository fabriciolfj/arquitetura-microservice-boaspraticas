package com.github.fabriciolfj.repository.extract;

import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.repository.extract.model.ExtractEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExtractEntityMapper {

    ExtractEntityMapper INSTANCE = Mappers.getMapper(ExtractEntityMapper.class);

    @Mapping(target = "product", source = "code")
    @Mapping(target = "daily", source = "dailyWithdrawal")
    @Mapping(target = "limit", source = "limitDailyWithDrawal")
    @Mapping(target = "rate", source = "rate")
    ExtractEntity toEntity(final Product product);
}
