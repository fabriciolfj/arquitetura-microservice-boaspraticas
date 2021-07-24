package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.business.LinkProduct;
import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.provider.product.ProductClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class ProductGateway implements LinkProduct {

    private final ProductClient productClient;

    @Override
    public void linkProduct(final Account account) {
        var product = productClient.find(account.getBalanceInit(), account.getCode());
        log.info("Product {} link customer {}", product, account.getCode());
    }
}
