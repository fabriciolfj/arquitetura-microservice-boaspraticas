package com.github.fabriciolfj.provider.product.decoder;

import com.github.fabriciolfj.entity.exceptions.ClientException;
import com.github.fabriciolfj.entity.exceptions.ProductClientException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(final String msg, final Response response) {
        switch (response.status()) {
            case 400:
            case 404:
                return new ProductClientException(msg);
            default:
                log.info("Http status return: {}", response.status());
                log.info("Details: {}", response.body());
                return new ClientException(msg);

        }
    }
}
