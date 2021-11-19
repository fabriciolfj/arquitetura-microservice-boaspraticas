package com.github.fabriciolfj.template.loader;

import com.github.fabriciolfj.controller.model.OperationDto;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.UUID;

@UtilityClass
public class OperationDtoTemplate {

    public OperationDto toRequestValid() {
        return OperationDto.builder()
                .account(UUID.randomUUID().toString())
                .value(BigDecimal.valueOf(100))
                .build();
    }

    public OperationDto toRequestAccountNotFound() {
        return OperationDto.builder()
                .account(null)
                .value(BigDecimal.valueOf(100))
                .build();
    }

    public OperationDto toRequestValueNotFound() {
        return OperationDto.builder()
                .account(UUID.randomUUID().toString())
                .value(BigDecimal.ZERO)
                .build();
    }

    public OperationDto toRequestInvalid() {
        return OperationDto.builder()
                .account(null)
                .value(BigDecimal.ZERO)
                .build();
    }

}
