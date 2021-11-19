package com.github.fabriciolfj.business.rules;

import com.github.fabriciolfj.business.FindProduct;
import com.github.fabriciolfj.business.rules.impl.RulePremium;
import com.github.fabriciolfj.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FacadeRuleCase {

    private final FindProduct findProduct;

    public Product execute(final BigDecimal balanceAccount) {
        var products = findProduct.findAll();
        return applyRule(balanceAccount, products);
    }

    private Product applyRule(final BigDecimal balanceAccount, final List<Product> products) {
        return new RulePremium(products, balanceAccount)
                .execute();
    }
}
