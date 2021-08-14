package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.business.product.ProductCreateCase;
import com.github.fabriciolfj.business.product.ProductGetCase;
import com.github.fabriciolfj.business.rules.FacadeRuleCase;
import com.github.fabriciolfj.controller.model.GetProductRequest;
import com.github.fabriciolfj.controller.model.GetProductResponse;
import com.github.fabriciolfj.providers.cache.UpdateCache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class ProductController {

    private final ProductCreateCase productCreateCase;
    private final ProductGetCase productGetCase;

    public GetProductResponse process(final GetProductRequest request) {
        var product = productCreateCase.execute(ProductControllerMapper.INSTANCE.toDomain(request));
        return ProductControllerMapper.INSTANCE.toResponse(product);
    }

    public GetProductResponse findProduct(final BigDecimal value, final String account) {
        var product = productGetCase.execute(value, account);
        return ProductControllerMapper.INSTANCE.toResponse(product);
    }

    public GetProductResponse findDescribeProduct(final String describe) {
        var product = productGetCase.execute(describe);
        return ProductControllerMapper.INSTANCE.toResponse(product);
    }
}
