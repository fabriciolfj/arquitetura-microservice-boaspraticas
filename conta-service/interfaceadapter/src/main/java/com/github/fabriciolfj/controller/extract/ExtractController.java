package com.github.fabriciolfj.controller.extract;

import com.github.fabriciolfj.business.extract.ExtractCase;
import com.github.fabriciolfj.controller.extract.model.ExtractMapper;
import com.github.fabriciolfj.controller.extract.model.ExtractResponse;
import com.github.fabriciolfj.entity.TypeOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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

    public Page<ExtractResponse> findExtract(final String account, final Pageable pageable) {
        final var result = extractCase.findAll(account, pageable);
        return result
                .map(value -> ExtractMapper.INSTANCE.toResponse(value));
    }
}
