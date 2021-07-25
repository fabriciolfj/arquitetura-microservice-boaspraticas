package com.github.fabriciolfj.business.account;

import com.github.fabriciolfj.entity.Account;

public interface FindAccount {

    Account find(final String code);
}
