package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.business.SaveProduct;
import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.repository.ProductEntityMapper;
import com.github.fabriciolfj.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Optional.of;

@Component
@RequiredArgsConstructor
public class ProductGateway implements SaveProduct {

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
}
