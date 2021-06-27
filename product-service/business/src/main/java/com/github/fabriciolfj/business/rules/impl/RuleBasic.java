package com.github.fabriciolfj.business.rules.impl;

import com.github.fabriciolfj.business.rules.RuleCase;
import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.entity.exceptions.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.List;

public class RuleBasic extends RuleCase {

    private final BigDecimal rate = BigDecimal.valueOf(2.0);

    public RuleBasic(final List<Product> products, final BigDecimal balanceAccount) {
        super(products, balanceAccount);
    }

    @Override
    public Product cast() {
        return products.stream()
                .filter(p -> p.getRate().compareTo(rate) > 0)
                .findAny()
                .orElseThrow(() -> new ProductNotFoundException("Product not found too rules"));
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
