package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.controller.model.GetProductRequest;
import com.github.fabriciolfj.controller.model.GetProductResponse;
import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.entity.Product.ProductBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-31T14:19:16-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
public class ProductControllerMapperImpl implements ProductControllerMapper {

    @Override
    public Product toDomain(GetProductRequest request) {
        if ( request == null ) {
            return null;
        }

        ProductBuilder product = Product.builder();

        product.describe( request.getDescribe() );
        if ( request.getDaily() != null ) {
            product.dailyWithdrawal( request.getDaily().intValue() );
        }
        product.limitDailyWithDrawal( request.getLimit() );
        product.rate( request.getRate() );

        return product.build();
    }

    @Override
    public GetProductResponse toResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        GetProductResponse getProductResponse = new GetProductResponse();

        getProductResponse.setCode( product.getCode() );

        return getProductResponse;
    }
}
