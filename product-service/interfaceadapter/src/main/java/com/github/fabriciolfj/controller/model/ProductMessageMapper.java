package com.github.fabriciolfj.controller.model;

import com.github.fabriciolfj.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMessageMapper {

    ProductMessageMapper INSTANCE = Mappers.getMapper(ProductMessageMapper.class);

    Product toDomain(final ProductMessageDTO dto);
}
