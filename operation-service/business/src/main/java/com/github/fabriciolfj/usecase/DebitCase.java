package com.github.fabriciolfj.usecase;

import com.github.fabriciolfj.CreateDebit;
import com.github.fabriciolfj.UpdateProduct;
import com.github.fabriciolfj.domain.entity.Product;
import com.github.fabriciolfj.domain.exceptions.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DebitCase {

    private final CreateDebit debit;
    private final UpdateProduct updateProduct;

    public void execute(final Optional<Product> product, final BigDecimal value, final String account) {
        product.ifPresentOrElse(p -> execute(p, value, account), () -> {
            throw new ProductNotFoundException("Product not found, to debit: " + value);
        });
    }

    private void execute(final Product product, final BigDecimal value, final String account) {
        if (product.isNotLimite()) {
            debit.createdDebit(product.getRate(), account);
        }

        debit.createdDebit(value, account);
        updateProduct.update(product, value, account);
    }
}
