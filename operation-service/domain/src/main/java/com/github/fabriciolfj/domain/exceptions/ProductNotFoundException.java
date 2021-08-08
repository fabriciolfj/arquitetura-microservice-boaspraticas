package com.github.fabriciolfj.domain.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(final String msg) {
        super(msg);
    }
}
