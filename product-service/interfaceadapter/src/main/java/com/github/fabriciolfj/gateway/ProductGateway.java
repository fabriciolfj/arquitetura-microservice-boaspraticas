package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.business.FindProduct;
import com.github.fabriciolfj.business.SaveProduct;
import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.entity.exceptions.ProductNotFoundException;
import com.github.fabriciolfj.repository.product.ProductEntityMapper;
import com.github.fabriciolfj.repository.product.ProductRepository;
import com.github.fabriciolfj.repository.product.specification.SpecificationProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.of;

@Component
@RequiredArgsConstructor
public class ProductGateway implements SaveProduct, FindProduct {

    private final ProductRepository productRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<Product> save(final Product product) {
        return of(ProductEntityMapper.INSTANCE.toEntity(product))
                .map(entity -> {
                    productRepository.save(entity);
                    return product;
                });
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductEntityMapper.INSTANCE::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Product findByName(final String describe) {
        return productRepository.findAll(
                Specification.where(SpecificationProduct.describe(describe)))
                .stream()
                .map(ProductEntityMapper.INSTANCE::toModel)
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found. Describe: " + describe));
    }

    @Override
    public Optional<Product> findByCode(String code) {
        return productRepository.findByCode(code)
                .map(ProductEntityMapper.INSTANCE::toModel);
    }
}
