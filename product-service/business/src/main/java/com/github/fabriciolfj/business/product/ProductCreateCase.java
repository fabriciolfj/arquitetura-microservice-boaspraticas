package com.github.fabriciolfj.business.product;

import com.github.fabriciolfj.business.SaveProduct;
import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.entity.exceptions.BusinessException;
import com.github.fabriciolfj.entity.exceptions.ProductCreateException;
import com.github.fabriciolfj.entity.state.StateActive;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Log4j2
@Component
@RequiredArgsConstructor
public class ProductCreateCase {

    private final SaveProduct saveProduct;
    private final ValidationCase validationCase;

    public Product execute(final Product product) {
        return ofNullable(validationCase.execute(product))
                .map(Product::generateCode)
                .map(p -> p.executeState(new StateActive()))
                .flatMap(this::save)
                .orElseThrow(() -> {
                    log.info("Fail created product");
                    return new BusinessException("Fail create product");
                });

    }

    private Optional<Product> save(final Product product) {
        try {
            return saveProduct.save(product);
        } catch (Exception e) {
            throw new ProductCreateException(e.getMessage());
        }
    }
}
