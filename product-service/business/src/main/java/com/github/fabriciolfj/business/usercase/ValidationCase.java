package com.github.fabriciolfj.business.usercase;

import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.entity.exceptions.ValidationProductException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.math.BigDecimal;

@Component
public class ValidationCase {

    public Product execute(final Product product) {
        try {
            Assert.notNull(product, "Product is null");
            Assert.notNull(product.getCode(), "Code product is null");
            Assert.notNull(product.getDailyWithdrawal(), "Daily withdrawal is null");
            Assert.notNull(product.getDescribe(), "Describe product is null");
            Assert.notNull(product.getLimitDailyWithDrawal(), "Limit product is null");
            Assert.notNull(product.getRate(), "Rate product is null");
            Assert.notNull(product.getRate().compareTo(BigDecimal.ZERO) > 0, "Rate product less than or equal to zero");
            Assert.notNull(product.getDailyWithdrawal() > 0, "Daily withdrawal less than or equal to zero");
            Assert.notNull(product.getLimitDailyWithDrawal().compareTo(BigDecimal.ZERO) > 0, "Limit product less than or equal to zero");

            return product;
        } catch (IllegalArgumentException e) {
            throw new ValidationProductException(e.getMessage());
        }

    }
}
