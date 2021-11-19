package com.github.fabriciolfj.domain.exceptions;

public class ProductNotFoundException extends BusinessException {

    public ProductNotFoundException(final String msg) {
        super(msg);
    }
}
