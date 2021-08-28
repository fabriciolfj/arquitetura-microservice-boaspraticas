package com.github.fabriciolfj.provider.product.http;

import com.github.fabriciolfj.provider.product.decoder.ProductConfiguration;
import com.github.fabriciolfj.provider.product.model.GetProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(url = "${app.product}", name = "product", configuration = ProductConfiguration.class)
public interface ProductClient {

    @GetMapping("/api/v1/products/{value}/{code}/link")
    GetProductResponse find(@PathVariable("value") final BigDecimal value, @PathVariable("code") final String customer);
}
