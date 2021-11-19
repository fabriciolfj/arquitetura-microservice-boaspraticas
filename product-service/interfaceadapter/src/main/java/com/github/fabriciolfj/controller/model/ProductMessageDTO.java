package com.github.fabriciolfj.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductMessageDTO {

    private String account;
    private String code;
    private Integer dailyWithdrawal;
    private BigDecimal limitDailyWithDrawal;
    private BigDecimal rate;
    private BigDecimal value;
}
