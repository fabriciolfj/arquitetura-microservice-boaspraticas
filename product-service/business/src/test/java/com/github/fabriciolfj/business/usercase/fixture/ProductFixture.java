package com.github.fabriciolfj.business.usercase.fixture;

import com.github.fabriciolfj.entity.Product;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductFixture {

    public static Product productSucess() {
        return Product.builder()
                .code(UUID.randomUUID().toString())
                .describe("Product test")
                .dailyWithdrawal(100)
                .limitDailyWithDrawal(BigDecimal.valueOf(1200.00))
                .rate(BigDecimal.valueOf(1.90))
                .build();
    }

    public static Product productRateNull() {
        return Product.builder()
                .code(UUID.randomUUID().toString())
                .describe("Product test")
                .dailyWithdrawal(100)
                .limitDailyWithDrawal(BigDecimal.valueOf(1200.00))
                .rate(null)
                .build();
    }
}
