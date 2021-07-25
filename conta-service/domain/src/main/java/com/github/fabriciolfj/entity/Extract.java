package com.github.fabriciolfj.entity;

import com.github.fabriciolfj.entity.exceptions.DomainException;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.github.fabriciolfj.entity.TypeOperation.CREDIT;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Extract {

    private static final int EQUALS = 0;
    private static final int DIF = 1;

    private String codeConta;
    private BigDecimal debit;
    private BigDecimal credit;
    private BigDecimal balance;
    private LocalDateTime date;

    public static Extract initial(final BigDecimal balance, final String code) {
        var extract = extractDefault(code);
        extract.setBalance(balance);
        extract.setCredit(balance);
        extract.setDebit(BigDecimal.ZERO);
        return extract;
    }

    public static Extract newExtract(final BigDecimal value, final String code, final TypeOperation operation) {
        var extract = extractDefault(code);
        switch (operation) {
            case CREDIT:
                extract.setCredit(value);
            case DEBIT:
                extract.setDebit(value);
        }

        return extract;
    }

    public Extract calculate(final Extract last) {
        var value = BigDecimal.ZERO;
        switch (debit.compareTo(BigDecimal.ZERO)) {
            case EQUALS:
                value = last.balance.add(credit);
                balance = value;
            case DIF:
                value = last.balance.subtract(debit);
                balance = value;
            default:
                throw new DomainException("Operation calculate extract fail");
        }
    }

    private static Extract extractDefault(final String code) {
        return Extract
                .builder()
                .codeConta(code)
                .date(LocalDateTime.now())
                .build();
    }
}
