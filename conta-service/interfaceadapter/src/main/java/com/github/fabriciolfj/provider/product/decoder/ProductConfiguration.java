package com.github.fabriciolfj.provider.product.decoder;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ProductErrorDecoder();
    }
}
