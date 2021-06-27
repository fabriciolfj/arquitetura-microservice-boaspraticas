package com.github.fabriciolfj.entity;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;

@Log4j2
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
public class Product {

    @EqualsAndHashCode.Include
    private String code;
    private String describe;
    private Integer dailyWithdrawal;
    private BigDecimal limitDailyWithDrawal;
    private BigDecimal rate;

    public BigDecimal applyRate(final BigDecimal value) {
        var rateApply = value.multiply(rate.divide(BigDecimal.valueOf(100)));
        log.info("Rate: {}", rateApply);
        return rateApply;
    }

    public void decrementDailyWithDrawal() {
        --dailyWithdrawal;
    }

    public void decrementLimit(final BigDecimal value) {
        var limit = limitDailyWithDrawal.subtract(value);
        log.info("Limit old: {}, Limite new: {}", limitDailyWithDrawal, limit);
        limitDailyWithDrawal = limit;
    }
}
