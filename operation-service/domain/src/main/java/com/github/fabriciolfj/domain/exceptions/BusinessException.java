package com.github.fabriciolfj.domain.exceptions;

public class BusinessException extends RuntimeException {

    public BusinessException(final String msg) {
        super(msg);
    }
}
