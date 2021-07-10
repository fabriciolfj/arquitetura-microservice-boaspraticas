package com.github.fabriciolfj.providers.cache;

import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.providers.cache.model.CacheMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class UpdateCache {

    @Qualifier("product")
    private final Cache cache;

    public void add(final Product product, final String customer) {
        var dto = CacheMapper.INSTANCE.toDto(product);
        log.info("Cache: {}", dto);
        cache.put(customer, dto);
    }
}
