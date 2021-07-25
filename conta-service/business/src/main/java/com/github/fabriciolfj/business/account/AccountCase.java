package com.github.fabriciolfj.business.account;

import com.github.fabriciolfj.business.LinkProduct;
import com.github.fabriciolfj.business.SaveAccount;
import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.entity.exceptions.CreateAccountException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Optional.of;

@Component
@RequiredArgsConstructor
public class AccountCase {

    private final SaveAccount saveAccount;
    private final LinkProduct linkProduct;

    public Account create(final Account account) {
        return of(account)
                .map(Account::genereteCode)
                .map(c -> {
                    var extrato = Extract.initial(account.getBalanceInit(), account.getCode());
                    return account.addExtrato(extrato);
                })
                .map(linkProduct::linkProduct)
                .flatMap(c -> saveAccount.save(c))
                .orElseThrow(() -> new CreateAccountException("Falha na criação da conta"));
    }
}
