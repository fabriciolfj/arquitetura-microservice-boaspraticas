package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.business.LinkProduct;
import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.provider.product.ProductProvider;
import com.github.fabriciolfj.provider.product.http.ProductClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class ProductGateway implements LinkProduct {

    private final ProductProvider productProvider;

    @Override
    public Account linkProduct(final Account account) {
        var product = productProvider.find(account.getBalanceInit(), account.getCode());
        log.info("Product {} link customer {}", product, account.getCode());
        return account.addProduct(product.getCode());
    }
}
