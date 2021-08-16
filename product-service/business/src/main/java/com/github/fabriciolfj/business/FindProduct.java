package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.Product;

import java.util.List;
import java.util.Optional;

public interface FindProduct {

    List<Product> findAll();

    Product findByName(final String describe);

    Optional<Product> findByCode(final String code);
}
