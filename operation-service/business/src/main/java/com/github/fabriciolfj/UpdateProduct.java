package com.github.fabriciolfj;

import com.github.fabriciolfj.domain.entity.Product;

import java.math.BigDecimal;

public interface UpdateProduct {

    void update(final Product product, final BigDecimal value, final String account);
}
