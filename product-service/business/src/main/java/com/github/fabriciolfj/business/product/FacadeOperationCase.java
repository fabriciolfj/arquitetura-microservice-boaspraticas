package com.github.fabriciolfj.business.product;

import com.github.fabriciolfj.business.LinkProductCustomer;
import com.github.fabriciolfj.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FacadeOperationCase {

    private final LinkProductCustomer linkProductCustomer;
    private final List<OperationsCase> operationsCases;

    public Product execute(final Product product, final BigDecimal value, final String account) {
        operationsCases.stream().forEach(c -> c.execute(product, value));
        linkProductCustomer.link(product, account);
        return product;
    }

}
