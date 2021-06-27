package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.business.account.AccountCase;
import com.github.fabriciolfj.controller.model.AccountMapper;
import com.github.fabriciolfj.controller.model.AccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountController {

    private final AccountCase accountCase;

    public void create(final AccountRequest request) {
        accountCase.create(AccountMapper.INSTANCE.toDomain(request));
    }

}
