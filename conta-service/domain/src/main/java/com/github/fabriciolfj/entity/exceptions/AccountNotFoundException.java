package com.github.fabriciolfj.entity.exceptions;

public class AccountNotFoundException extends DomainException {

    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
