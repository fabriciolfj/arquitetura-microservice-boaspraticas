package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.CreateCredit;
import com.github.fabriciolfj.CreateDebit;
import com.github.fabriciolfj.provider.http.AccountClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class AccountGateway implements CreateCredit, CreateDebit {

    private final AccountClient accountClient;

    @Override
    public void createdCredit(final BigDecimal value, final String code) {
        accountClient.requestCredit(value, code);
    }

    @Override
    public void createdDebit(final BigDecimal value, final String code) {
        accountClient.requestDebit(value, code);
    }
}
