package com.github.fabriciolfj.usecase;

import com.github.fabriciolfj.CreateCredit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class CreditCase {

    private final CreateCredit createCredit;

    public void execute(final String account, final BigDecimal value) {
        createCredit.createdCredit(value, account);
    }
}
