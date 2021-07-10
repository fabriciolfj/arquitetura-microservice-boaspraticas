package com.github.fabriciolfj.business.product;

import com.github.fabriciolfj.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class UpdateWithdrawCase {

    public Product execute(final Product product) {
        product.decrementDailyWithDrawal();
        return product;
    }
}
