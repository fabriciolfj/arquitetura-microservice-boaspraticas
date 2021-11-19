package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.UpdateProduct;
import com.github.fabriciolfj.domain.entity.Product;
import com.github.fabriciolfj.provider.message.ProductMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class ProductGateway implements UpdateProduct {

    private final ProductMessage productMessage;
    @Override
    public void update(final Product product, final BigDecimal value, final String account) {
        productMessage.execute(product, value, account);
    }
}
