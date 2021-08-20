package com.github.fabriciolfj.provider.product;

import com.github.fabriciolfj.provider.product.http.ProductClient;
import com.github.fabriciolfj.provider.product.model.GetProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class ProductProvider {

    private final ProductClient client;

    public GetProductResponse find(final BigDecimal value, final String customer) {
        return client.find(value, customer);
    }
}
