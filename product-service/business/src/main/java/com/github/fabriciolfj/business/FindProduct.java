package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.Product;

import java.util.List;

public interface FindProduct {

    List<Product> findAll();

    Product findByName(final String describe);
}
