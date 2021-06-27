package com.github.fabriciolfj.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Extract {

    private String codeConta;
    private BigDecimal debit;
    private BigDecimal credit;
    private BigDecimal balance;
    private LocalDateTime date;

    public static Extract execute(final BigDecimal balance, final String code) {
        return Extract
                .builder()
                .debit(BigDecimal.ZERO)
                .credit(balance)
                .codeConta(code)
                .balance(balance)
                .date(LocalDateTime.now())
                .build();
    }
}
