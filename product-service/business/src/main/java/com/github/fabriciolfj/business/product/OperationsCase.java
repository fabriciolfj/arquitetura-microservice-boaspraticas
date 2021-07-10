package com.github.fabriciolfj.business.product;

import com.github.fabriciolfj.entity.Product;

import java.math.BigDecimal;

public interface OperationsCase {

    void execute(final Product product, final BigDecimal value);
}
