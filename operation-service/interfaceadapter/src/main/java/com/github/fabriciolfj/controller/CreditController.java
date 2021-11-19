package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.controller.model.OperationDto;
import com.github.fabriciolfj.usecase.CreditCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreditController {

    private final CreditCase creditCase;

    public void create(final OperationDto dto) {
        creditCase.execute(dto.getAccount(), dto.getValue());
    }
}
