package com.github.fabriciolfj.template.loader;

import com.github.fabriciolfj.domain.entity.Product;
import com.github.fabriciolfj.provider.cache.model.ProductCacheDTO;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.UUID;

@UtilityClass
public class ProductDtoTemplate {

    public ProductCacheDTO toValid() {
        return ProductCacheDTO.builder()
                .code(UUID.randomUUID().toString())
                .dailyWithdrawal(100)
                .limitDailyWithDrawal(BigDecimal.valueOf(1000))
                .rate(BigDecimal.valueOf(1.0))
                .build();
    }
}
