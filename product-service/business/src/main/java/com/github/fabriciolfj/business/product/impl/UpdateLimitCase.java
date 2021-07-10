package com.github.fabriciolfj.business.product.impl;

import com.github.fabriciolfj.business.product.OperationsCase;
import com.github.fabriciolfj.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class UpdateLimitCase implements OperationsCase {

    @Override
    public void execute(final Product product, final BigDecimal value) {
        product.decrementLimit(value);
    }
}
