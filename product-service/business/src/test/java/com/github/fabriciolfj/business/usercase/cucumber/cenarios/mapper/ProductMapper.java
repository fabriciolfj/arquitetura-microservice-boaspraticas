package com.github.fabriciolfj.business.usercase.cucumber.cenarios.mapper;

import com.github.fabriciolfj.entity.Product;
import io.cucumber.datatable.DataTable;

import java.math.BigDecimal;

public class ProductMapper {

    public static Product toProduct(final DataTable dataTable) {
        var values = dataTable.asMaps();
        return values.stream().findFirst()
                .map(v ->
                    Product.builder()
                            .code(v.get("code"))
                            .dailyWithdrawal(Integer.parseInt(v.get("dailyWithdrawal")))
                            .describe(v.get("describe"))
                            .limitDailyWithDrawal(new BigDecimal(v.get("limitDailyWithDrawal")))
                            .status(Integer.parseInt(v.get("status")))
                            .rate(new BigDecimal(v.get("rate")))
                            .build()
                )
                .orElse(null);
    }
}
