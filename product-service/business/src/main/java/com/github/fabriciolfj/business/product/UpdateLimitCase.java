package com.github.fabriciolfj.business.product;

import com.github.fabriciolfj.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UpdateLimitCase {

    public Product execute(final Product extract, final BigDecimal value) {
        extract.decrementLimit(value);
        return extract;
    }
}
