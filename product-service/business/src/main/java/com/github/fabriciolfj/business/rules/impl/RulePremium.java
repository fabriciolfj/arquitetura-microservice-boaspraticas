package com.github.fabriciolfj.business.rules.impl;

import com.github.fabriciolfj.business.rules.RuleCase;
import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.entity.exceptions.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.List;

public class RulePremium extends RuleCase {

    private final BigDecimal rate = BigDecimal.valueOf(1.9);
    private final BigDecimal value = BigDecimal.valueOf(1000.00);

    public RulePremium(final List<Product> products, final BigDecimal balanceAccount) {
        super(products, balanceAccount);
    }

    @Override
    public Product cast() {
        return products
                .stream()
                .filter(p -> p.getRate().compareTo(rate) <= 0)
                .findAny()
                .orElseThrow(() -> new ProductNotFoundException("Product not found rule premium"));
    }

    @Override
    public void setAppointmentCase() {
        this.appointmentCase = new RuleIntermediary(this.products, this.balanceAccount);
    }

    @Override
    public boolean isValid() {
        return getBalanceAccount().compareTo(value) >= 0;
    }
}
