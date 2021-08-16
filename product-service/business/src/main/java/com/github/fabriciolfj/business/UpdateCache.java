package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.Product;

public interface UpdateCache {

    void execute(final Product product, final String account);
}
