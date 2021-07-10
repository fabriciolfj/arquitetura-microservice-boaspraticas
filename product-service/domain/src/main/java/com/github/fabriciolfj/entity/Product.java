package com.github.fabriciolfj.entity;

import com.github.fabriciolfj.entity.state.State;
import com.github.fabriciolfj.entity.state.StateActive;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import java.math.BigDecimal;
import java.util.UUID;

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
    private Integer status;

    public void decrementDailyWithDrawal() {
        --dailyWithdrawal;
    }

    public void decrementLimit(final BigDecimal value) {
        var limit = limitDailyWithDrawal.subtract(value);
        log.info("Limit old: {}, Limite new: {}", limitDailyWithDrawal, limit);
        limitDailyWithDrawal = limit;
    }

    public Product generateCode() {
        this.code = UUID.randomUUID().toString();
        return this;
    }

    public Product executeState(final State state) {
        state.execute(this);
        return this;
    }
}
