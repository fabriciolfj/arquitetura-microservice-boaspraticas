package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.Product;

public interface LinkProductCustomer {

    void link(final Product product, final String account);
}
