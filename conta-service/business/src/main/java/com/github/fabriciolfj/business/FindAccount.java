package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.Account;

import java.util.Optional;

public interface FindAccount {

    Optional<Account> findAccountByCPF(final String cpf);
}
