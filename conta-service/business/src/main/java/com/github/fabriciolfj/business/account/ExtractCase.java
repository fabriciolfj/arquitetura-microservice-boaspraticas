package com.github.fabriciolfj.business.account;

import com.github.fabriciolfj.business.CreateExtract;
import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.entity.TypeOperation;
import com.github.fabriciolfj.entity.exceptions.ExtractProcessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExtractCase {

    private final CreateExtract createExtract;

    public Extract execute(final String codeAccount, final BigDecimal value, final TypeOperation typeOperation) {
        return Optional.ofNullable(codeAccount)
                .map(extract -> Extract.newExtract(value, codeAccount, typeOperation))
                .map(ext -> {
                    createExtract.create(ext);
                    return ext;
                })
                .orElseThrow(() -> new ExtractProcessException("Fail processo execute extract by account: " + codeAccount));

    }
}
