package com.github.fabriciolfj.business.usercase;

import com.github.fabriciolfj.business.SaveProduct;
import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.entity.exceptions.BusinessException;
import com.github.fabriciolfj.entity.exceptions.ProductCreateException;
import com.github.fabriciolfj.entity.exceptions.ValidationProductException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

@Log4j2
@Component
@RequiredArgsConstructor
public class ProductCreateCase {

    private final SaveProduct saveProduct;
    private final ValidationCase validationCase;

    public Product execute(final Product product) {
        return ofNullable(validationCase.execute(product))
                .flatMap(this::save)
                .orElseThrow(() -> {
                    log.info("Fail created product");
                    return new BusinessException("Fail create product");
                });

    }

    private Optional<Product> save(final Product product) {
        return saveProduct.save(product);
    }
}
