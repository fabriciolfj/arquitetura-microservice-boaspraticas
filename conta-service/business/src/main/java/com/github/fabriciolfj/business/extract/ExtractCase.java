package com.github.fabriciolfj.business.extract;

import com.github.fabriciolfj.business.FindExtract;
import com.github.fabriciolfj.business.SaveExtract;
import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.entity.TypeOperation;
import com.github.fabriciolfj.entity.exceptions.ExtractProcessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
public class ExtractCase {

    private final FindExtract findExtract;
    private final SaveExtract saveExtract;

    public Extract execute(final String codeAccount, final BigDecimal value, final TypeOperation typeOperation) {
        return ofNullable(codeAccount)
                .flatMap(findExtract::findLast)
                .map(extract -> {
                    var newExtract = Extract.newExtract(value, codeAccount, typeOperation);
                    return newExtract.calculate(extract);
                })
                .map(this::save)
                .orElseThrow(() -> new ExtractProcessException("Fail processo execute extract by account: " + codeAccount));

    }

    private Extract save(final Extract extract) {
        try {
            saveExtract.save(extract);
            return extract;
        } catch (Exception e) {
            throw new ExtractProcessException("Fail save extract, details: " + e.getMessage());
        }
    }
}
