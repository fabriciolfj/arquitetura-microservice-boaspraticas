package com.github.fabriciolfj.business.product;

import com.github.fabriciolfj.business.FindProduct;
import com.github.fabriciolfj.business.rules.FacadeRuleCase;
import com.github.fabriciolfj.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class ProductGetCase {

    private final FindProduct findProduct;
    private final FacadeRuleCase facadeRuleCase;

    public Product execute(final BigDecimal value) {
        return facadeRuleCase.execute(value);
    }

    public Product execute(final String describe) {
        return findProduct.findByName(describe);
    }
}
