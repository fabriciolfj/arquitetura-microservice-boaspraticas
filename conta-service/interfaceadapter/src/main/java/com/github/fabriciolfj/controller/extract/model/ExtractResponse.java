package com.github.fabriciolfj.controller.extract.model;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExtractResponse {

    private String codeConta;
    private BigDecimal debit;
    private BigDecimal credit;
    private BigDecimal balance;
    private LocalDateTime date;
}
