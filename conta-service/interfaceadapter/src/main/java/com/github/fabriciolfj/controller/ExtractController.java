package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.business.account.ExtractCase;
import com.github.fabriciolfj.entity.TypeOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Log4j2
@RequiredArgsConstructor
public class ExtractController {

    private final ExtractCase extractCase;

    public void createDebit(final String code, final BigDecimal value) {
        log.info("Create debit {}, {}", code, value);
        extractCase.execute(code, value, TypeOperation.DEBIT);
    }

    public void createCredit(final String code, final BigDecimal value) {
        log.info("Create credit {}, {}", code, value);
        extractCase.execute(code, value, TypeOperation.CREDIT);
    }
}
