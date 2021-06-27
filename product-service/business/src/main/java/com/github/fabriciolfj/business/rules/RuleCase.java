package com.github.fabriciolfj.business.rules;

import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.entity.exceptions.BusinessException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Getter
public abstract class RuleCase {

    protected final List<Product> products;
    protected final BigDecimal balanceAccount;
    protected RuleCase appointmentCase;

    public Product execute() {
        if (isValid()) {
            return cast();
        }

        setAppointmentCase();
        return appointmentCase.execute();
    }

    public abstract Product cast();

    public void setAppointmentCase() {
        throw  new BusinessException("Appointment not applied");
    };

    public boolean isValid() {
        throw new BusinessException("Rule not applied");
    };
}
