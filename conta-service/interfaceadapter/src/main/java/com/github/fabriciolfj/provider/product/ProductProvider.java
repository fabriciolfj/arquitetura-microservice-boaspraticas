package com.github.fabriciolfj.provider.product;

import com.github.fabriciolfj.provider.product.http.ProductClient;
import com.github.fabriciolfj.provider.product.model.GetProductResponse;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductProvider {

    private final ProductClient client;

    @Retry(name = "product", fallbackMethod = "findFallback")
    public GetProductResponse find(final BigDecimal value, final String customer) {
        return client.find(value, customer);
    }

    public GetProductResponse findFallback(final BigDecimal value, final String customer, final Throwable t) {
        log.error("Fail consumer product: {}", t.getMessage());
        return GetProductResponse.builder()
                .code(UUID.randomUUID().toString())
                .build();
    }
}
