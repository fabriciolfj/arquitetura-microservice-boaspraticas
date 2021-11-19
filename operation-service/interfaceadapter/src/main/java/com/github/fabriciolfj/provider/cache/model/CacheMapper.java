package com.github.fabriciolfj.provider.cache.model;

import com.github.fabriciolfj.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CacheMapper {

    CacheMapper INSTANCE = Mappers.getMapper(CacheMapper.class);

    Product toEntity(final ProductCacheDTO product);
}
