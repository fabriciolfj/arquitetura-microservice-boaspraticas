package com.github.fabriciolfj.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Getter
@Setter
public class GetProductRequest {

    @NotEmpty(message = "describe required")
    private String describe;
    @NotNull(message = "rate not informed")
    @PositiveOrZero(message = "rate greater than zero or equals zero")
    private BigDecimal rate;
    @NotNull(message = "daily not informed")
    @Positive(message = "daily greater than zero")
    private BigDecimal daily;
    @NotNull(message = "limit not informed")
    @Positive(message = "limit greater than zero")
    private BigDecimal limit;
}
