package com.github.fabriciolfj.provider.http.account;

import com.github.fabriciolfj.domain.exceptions.AccountException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class AccountDecoder implements ErrorDecoder {

    private final ErrorDecoder delegate = new ErrorDecoder.Default();

    @Override
    public Exception decode(final String msg, final Response response) {

        if (response.status() == HttpStatus.BAD_REQUEST.value()) {
            throw new AccountException(msg + " , http status: " + response.status());
        }

        return delegate.decode(msg, response);
    }
}
