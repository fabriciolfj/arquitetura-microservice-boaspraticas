package com.github.fabriciolfj;

import java.math.BigDecimal;

public interface CreateDebit {

    void createdDebit(final BigDecimal value, final String code);
}
