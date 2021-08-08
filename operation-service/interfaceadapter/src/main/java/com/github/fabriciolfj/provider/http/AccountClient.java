package com.github.fabriciolfj.provider.http;

import com.github.fabriciolfj.provider.http.account.AccountConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@FeignClient(url = "${account.url}", name = "account", configuration = AccountConfiguration.class)
public interface AccountClient {

    @PostMapping("/v1/extract/debit")
    void requestDebit(@RequestParam("value") final BigDecimal value, @RequestParam("code") final String code);

    @PostMapping("/v1/extract/credit")
    void requestCredit(@RequestParam("value") final BigDecimal value, @RequestParam("code") final String code);

}
