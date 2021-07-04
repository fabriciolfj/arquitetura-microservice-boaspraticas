package com.github.fabriciolfj.repository;

import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.entity.Product.ProductBuilder;
import com.github.fabriciolfj.repository.model.ProductEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-04T19:33:51-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
public class ProductEntityMapperImpl implements ProductEntityMapper {

    @Override
    public ProductEntity toEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setCode( product.getCode() );
        productEntity.setDescribe( product.getDescribe() );
        productEntity.setDaily( product.getDailyWithdrawal() );
        productEntity.setLimit( product.getLimitDailyWithDrawal() );
        productEntity.setRate( product.getRate() );
        productEntity.setStatus( product.getStatus() );

        return productEntity;
    }

    @Override
    public Product toModel(ProductEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProductBuilder product = Product.builder();

        product.code( entity.getCode() );
        product.describe( entity.getDescribe() );
        product.dailyWithdrawal( entity.getDaily() );
        product.limitDailyWithDrawal( entity.getLimit() );
        product.rate( entity.getRate() );
        product.status( entity.getStatus() );

        return product.build();
    }
}
