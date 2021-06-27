package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.business.usercase.ProductCreateCase;
import com.github.fabriciolfj.controller.model.GetProductRequest;
import com.github.fabriciolfj.controller.model.GetProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductController {

    private final ProductCreateCase productCreateCase;

    public GetProductResponse process(final GetProductRequest request) {
        var product = productCreateCase.execute(ProductControllerMapper.INSTANCE.toDomain(request));
        return ProductControllerMapper.INSTANCE.toResponse(product);
    }
}
