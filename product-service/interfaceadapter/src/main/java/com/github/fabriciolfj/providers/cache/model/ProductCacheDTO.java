package com.github.fabriciolfj.providers.cache.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCacheDTO {

    private String code;
    private Integer dailyWithdrawal;
    private BigDecimal limitDailyWithDrawal;
    private BigDecimal rate;
}
