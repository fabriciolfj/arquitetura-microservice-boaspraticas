package com.github.fabriciolfj.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    private String code;
    private Integer dailyWithdrawal;
    private BigDecimal limitDailyWithDrawal;
    private BigDecimal rate;

    public boolean isNotLimite() {
        if (dailyWithdrawal <= 0 || limitDailyWithDrawal.compareTo(BigDecimal.ZERO) <= 0) {
            return true;
        }

        return false;
    }
}
