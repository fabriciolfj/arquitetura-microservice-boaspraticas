package com.github.fabriciolfj.provider.message.model;

import com.github.fabriciolfj.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMessageMapper {

    ProductMessageMapper INSTANCE = Mappers.getMapper(ProductMessageMapper.class);

    ProductMessageDTO toDto(final Product product);
}
