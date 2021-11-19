package com.github.fabriciolfj.provider.message;

import com.github.fabriciolfj.domain.entity.Product;
import com.github.fabriciolfj.provider.message.model.ProductMessageDTO;
import com.github.fabriciolfj.provider.message.model.ProductMessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class ProductMessage {

    public final StreamBridge streamBridge;

    public void execute(final Product product, final BigDecimal value, final String account) {
        final ProductMessageDTO dto = ProductMessageMapper.INSTANCE.toDto(product);
        dto.setValue(value);
        dto.setAccount(account);

        streamBridge.send("product-out-0", dto);
    }
}
