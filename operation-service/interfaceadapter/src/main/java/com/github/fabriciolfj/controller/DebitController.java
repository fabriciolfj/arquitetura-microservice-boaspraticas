package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.domain.entity.Product;
import com.github.fabriciolfj.controller.model.OperationDto;
import com.github.fabriciolfj.gateway.ProductCacheGateway;
import com.github.fabriciolfj.provider.cache.model.CacheMapper;
import com.github.fabriciolfj.usecase.DebitCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DebitController {

    private final DebitCase debitCase;
    private final ProductCacheGateway cacheProvider;

    public void execute (final OperationDto dto) {
        final Optional<Product> product = cacheProvider.getCache(dto.getAccount())
                .map(CacheMapper.INSTANCE::toEntity);
        debitCase.execute(product, dto.getValue(), dto.getAccount());
    }
}
