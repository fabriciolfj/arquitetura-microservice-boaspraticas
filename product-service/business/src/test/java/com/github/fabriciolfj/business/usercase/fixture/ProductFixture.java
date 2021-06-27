package com.github.fabriciolfj.business.usercase.fixture;

import com.github.fabriciolfj.entity.Product;

import java.math.BigDecimal;
import java.util.List;
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

    public static List<Product> productsSucess() {
        var prod1= Product.builder()
                .code(UUID.randomUUID().toString())
                .describe("Product test")
                .dailyWithdrawal(2)
                .limitDailyWithDrawal(BigDecimal.valueOf(875.00))
                .rate(BigDecimal.valueOf(1.90))
                .build();

        var prod2= Product.builder()
                .code(UUID.randomUUID().toString())
                .describe("Product test")
                .dailyWithdrawal(5)
                .limitDailyWithDrawal(BigDecimal.valueOf(1200.00))
                .rate(BigDecimal.valueOf(0.2))
                .build();

        var prod3= Product.builder()
                .code(UUID.randomUUID().toString())
                .describe("Product test")
                .dailyWithdrawal(6)
                .limitDailyWithDrawal(BigDecimal.valueOf(2000.00))
                .rate(BigDecimal.valueOf(1.2))
                .build();

        var prod4= Product.builder()
                .code(UUID.randomUUID().toString())
                .describe("Product test")
                .dailyWithdrawal(1)
                .limitDailyWithDrawal(BigDecimal.valueOf(200.00))
                .rate(BigDecimal.valueOf(5))
                .build();

        return List.of(prod1, prod2, prod3, prod4);
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
