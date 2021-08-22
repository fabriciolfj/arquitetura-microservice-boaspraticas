package com.github.fabriciolfj.controller.account.model;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {

    @CPF(message = "Cpf invalido")
    private String cpf;
    @PositiveOrZero(message = "Informe um valor acima de zero")
    private BigDecimal balance;
}
