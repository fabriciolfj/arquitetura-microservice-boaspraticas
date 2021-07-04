package com.github.fabriciolfj.repository;

import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.repository.model.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductEntityMapper {

    ProductEntityMapper INSTANCE = Mappers.getMapper(ProductEntityMapper.class);

    @Mapping(target = "code", source = "code")
    @Mapping(target = "describe", source = "describe")
    @Mapping(target = "daily", source = "dailyWithdrawal")
    @Mapping(target = "limit", source = "limitDailyWithDrawal")
    @Mapping(target = "rate", source = "rate")
    @Mapping(target = "status", source = "status")
    ProductEntity toEntity(final Product product);

    @Mapping(source = "code", target = "code")
    @Mapping(source = "describe", target = "describe")
    @Mapping(source = "daily", target = "dailyWithdrawal")
    @Mapping(source = "limit", target = "limitDailyWithDrawal")
    @Mapping(source = "rate", target = "rate")
    @Mapping(source = "status", target = "status")
    Product toModel(final ProductEntity entity);
}
