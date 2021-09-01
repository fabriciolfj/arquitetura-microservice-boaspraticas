package com.github.fabriciolfj.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationDto {

    @NotBlank(message = "{account.notfound}")
    private String account;
    @Positive(message = "{value.invalid}")
    private BigDecimal value;
}
