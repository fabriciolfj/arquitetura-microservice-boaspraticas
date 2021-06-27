package com.github.fabriciolfj.business.rules.impl;

import com.github.fabriciolfj.business.rules.RuleCase;
import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.entity.exceptions.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.List;

public class RuleIntermediary extends RuleCase {

    private final BigDecimal rate = BigDecimal.valueOf(2.0);
    private final BigDecimal value = BigDecimal.valueOf(500.00);

    public RuleIntermediary(final List<Product>  products, final BigDecimal balanceAccount) {
        super(products, balanceAccount);
    }

    @Override
    public Product cast() {
        return products
                .stream()
                .filter(p -> p.getRate().compareTo(rate) <= 0)
                .findAny()
                .orElseThrow(() -> new ProductNotFoundException("Product not found too rule intermediary"));
    }

    @Override
    public void setAppointmentCase() {
        this.appointmentCase = new RuleBasic(this.products, this.balanceAccount);
    }

    @Override
    public boolean isValid() {
        return this.balanceAccount.compareTo(value) > 0;
    }
}
