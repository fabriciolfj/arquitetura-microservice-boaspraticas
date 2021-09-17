package com.github.fabriciolfj.business.extract;

import com.github.fabriciolfj.business.FindAllExtract;
import com.github.fabriciolfj.business.FindProduct;
import com.github.fabriciolfj.business.UpdateCache;
import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.entity.exceptions.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExtractCase {

    private final FindAllExtract findAllExtract;
    private final FindProduct findProduct;
    private final UpdateCache updateCache;

    public void execute() {
        findAllExtract.findAll()
                .stream()
                .forEach(e -> {
                    var product = reset(e.getProduct());
                    updateCache.execute(product, e.getAccount());
                });
    }

    //Resetar com base no produto
    private Product reset(final String product) {
        return findProduct.findByCode(product)
                .orElseThrow(() -> new ProductNotFoundException("Product not found: " + product));
    }
}
