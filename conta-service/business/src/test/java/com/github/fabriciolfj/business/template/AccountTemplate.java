package com.github.fabriciolfj.business.template;

import com.github.fabriciolfj.entity.Account;

import java.math.BigDecimal;


public class AccountTemplate {

    public Account getAccountValid() {
        return Account.builder()
                .balanceInit(BigDecimal.valueOf(100.00))
                .cpf("33967386895")
                .build();
    }
}
