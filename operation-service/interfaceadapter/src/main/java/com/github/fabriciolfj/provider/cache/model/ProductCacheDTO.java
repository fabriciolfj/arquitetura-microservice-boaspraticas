package com.github.fabriciolfj.provider.cache.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCacheDTO {

    private String code;
    private Integer dailyWithdrawal;
    private BigDecimal limitDailyWithDrawal;
    private BigDecimal rate;
}
