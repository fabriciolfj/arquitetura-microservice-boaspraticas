package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.business.product.FacadeOperationCase;
import com.github.fabriciolfj.controller.model.ProductMessageDTO;
import com.github.fabriciolfj.controller.model.ProductMessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Log4j2
@Component
@RequiredArgsConstructor
public class MessageController {

    private final FacadeOperationCase facadeOperationCase;

    @Bean
    public Consumer<ProductMessageDTO> operation() {
        return c -> {
            log.info("Received limite message: {}", c.toString());
            facadeOperationCase.execute(ProductMessageMapper.INSTANCE.toDomain(c), c.getValue(), c.getCustomer());
        };
    }
}
