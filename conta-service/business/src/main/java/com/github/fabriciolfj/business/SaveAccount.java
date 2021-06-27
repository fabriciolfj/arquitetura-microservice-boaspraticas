package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.Account;

import java.util.Optional;

public interface SaveAccount {

    Optional<Account> save(final Account account);
}
