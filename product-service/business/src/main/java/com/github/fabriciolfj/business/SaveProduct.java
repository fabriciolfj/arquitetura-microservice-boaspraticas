package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.Product;

import java.util.Optional;

public interface SaveProduct {

    Optional<Product> save(final Product product);
}
