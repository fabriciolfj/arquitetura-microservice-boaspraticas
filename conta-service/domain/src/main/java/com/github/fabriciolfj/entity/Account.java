package com.github.fabriciolfj.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Account {

    @EqualsAndHashCode.Include
    private String code;
    @EqualsAndHashCode.Include
    private String cpf;
    private BigDecimal balanceInit;
    private List<Extract> extracts;
    private String product;

    public Account addProduct(final String code) {
        product = code;
        return this;
    }

    public Account addExtrato(final Extract extract) {
        if (this.extracts == null) {
            this.extracts = new ArrayList<>();
        }

        this.extracts.add(extract);
        return this;
    }

    public Account genereteCode() {
        this.code = UUID.randomUUID().toString();
        return this;
    }

}
