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
    private List<Extract> extracts = new ArrayList<>();

    public Account addExtrato(final Extract extract) {
        this.extracts.add(extract);
        return this;
    }

    public Account genereteCode() {
        this.code = UUID.randomUUID().toString();
        return this;
    }

}
