package com.github.fabriciolfj.providers.cache.model;

import com.github.fabriciolfj.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CacheMapper {

    CacheMapper INSTANCE = Mappers.getMapper(CacheMapper.class);

    ProductCacheDTO toDto(final Product product);
}
