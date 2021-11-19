package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.controller.model.GetProductRequest;
import com.github.fabriciolfj.controller.model.GetProductResponse;
import com.github.fabriciolfj.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductControllerMapper {

    ProductControllerMapper INSTANCE = Mappers.getMapper(ProductControllerMapper.class);

    @Mapping(target = "describe", source = "describe")
    @Mapping(target = "dailyWithdrawal", source = "daily")
    @Mapping(target = "limitDailyWithDrawal", source = "limit")
    @Mapping(target = "rate", source = "rate")
    Product toDomain(final GetProductRequest request);

    @Mapping(target = "code", source = "code")
    GetProductResponse toResponse(final Product product);
}
