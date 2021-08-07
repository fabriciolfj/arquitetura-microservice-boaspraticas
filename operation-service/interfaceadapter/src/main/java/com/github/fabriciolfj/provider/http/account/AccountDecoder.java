package com.github.fabriciolfj.provider.http.account;

import feign.Response;
import feign.codec.ErrorDecoder;

import javax.security.auth.login.AccountException;

public class AccountDecoder implements ErrorDecoder {

    @Override
    public Exception decode(final String msg, final Response response) {
        return new AccountException(msg + " , http status: " + response.status());
    }
}
