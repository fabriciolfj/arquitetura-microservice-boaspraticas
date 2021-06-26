package com.github.fabriciolfj.entity;

import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Extract {

    @EqualsAndHashCode.Include
    private String codeConta;
    private BigDecimal debit;
    private BigDecimal credit;
    private BigDecimal balance;

    public static Extract createIni(final BigDecimal balance, final String code) {
        return Extract
                .builder()
                .debit(BigDecimal.ZERO)
                .credit(balance)
                .codeConta(code)
                .balance(balance)
                .build();
    }
}
