package com.github.fabriciolfj.provider.http;

import com.github.fabriciolfj.provider.http.account.AccountConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(url = "${account.url}", name = "account", configuration = AccountConfiguration.class)
public interface AccountClient {

    @PostMapping("/debit")
    void requestDebit(@RequestParam("value") final BigDecimal value, @RequestParam("code") final String code);

    @PostMapping("/credit")
    void requestCredit(@RequestParam("value") final BigDecimal value, @RequestParam("code") final String code);
}
