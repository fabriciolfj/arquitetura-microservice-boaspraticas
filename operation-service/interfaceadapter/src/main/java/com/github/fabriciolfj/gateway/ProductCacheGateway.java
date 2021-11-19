package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.provider.cache.model.ProductCacheDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductCacheGateway {

    @Qualifier("product")
    private final Cache cacheManager;

    public Optional<ProductCacheDTO> getCache(final String customer) {
        return Optional.ofNullable(cacheManager.get(customer, ProductCacheDTO.class));
    }
}
