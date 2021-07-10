package com.github.fabriciolfj.repository.product.specification;

import com.github.fabriciolfj.repository.product.model.ProductEntity;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationProduct {

    public static Specification<ProductEntity> describe(final String describe) {
        return (root, query, builder) -> builder.like(root.get("describe"), "%"  + describe + "%");
    }
}
