package com.github.fabriciolfj.provider.product.decoder;

import com.github.fabriciolfj.entity.exceptions.ClientException;
import com.github.fabriciolfj.entity.exceptions.ProductClientException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ProductErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(final String msg, final Response response) {
        switch (response.status()) {
            case 400:
                return new ProductClientException(msg);
            default:
                return new ClientException(msg);

        }
    }
}
