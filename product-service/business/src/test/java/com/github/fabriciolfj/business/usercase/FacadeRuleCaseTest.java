package com.github.fabriciolfj.business.usercase;

import com.github.fabriciolfj.business.FindProduct;
import com.github.fabriciolfj.business.rules.FacadeRuleCase;
import com.github.fabriciolfj.business.usercase.fixture.ProductFixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class FacadeRuleCaseTest {

    @Mock
    private FindProduct findProduct;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        when(findProduct.findAll()).thenReturn(ProductFixture.productsSucess());
    }

    @Test
    public void getProductPremium() {
        var rule = new FacadeRuleCase(findProduct);
        var product = rule.execute(BigDecimal.valueOf(1000));

        assertTrue(product != null);
        assertTrue(product.getRate().compareTo(BigDecimal.valueOf(1.9)) <= 0);
    }

    @Test
    public void getProductIntermediary() {
        var rule = new FacadeRuleCase(findProduct);
        var product = rule.execute(BigDecimal.valueOf(650));

        assertTrue(product != null);
        assertTrue(product.getRate().compareTo(BigDecimal.valueOf(2.0)) <= 0);
    }

    @Test
    public void getProductInterBasic() {
        var rule = new FacadeRuleCase(findProduct);
        var product = rule.execute(BigDecimal.valueOf(150));

        assertTrue(product != null);
        assertTrue(product.getRate().compareTo(BigDecimal.valueOf(2.0)) > 0);
    }
}
