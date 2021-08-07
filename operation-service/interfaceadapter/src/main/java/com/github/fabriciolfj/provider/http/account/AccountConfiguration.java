package com.github.fabriciolfj.provider.http.account;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new AccountDecoder();
    }
}
