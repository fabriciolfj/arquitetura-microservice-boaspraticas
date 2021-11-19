package com.github.fabriciolfj.business.usercase;

import com.github.fabriciolfj.business.LinkProductCustomer;
import com.github.fabriciolfj.business.product.FacadeOperationCase;
import com.github.fabriciolfj.business.product.OperationsCase;
import com.github.fabriciolfj.business.product.impl.UpdateLimitCase;
import com.github.fabriciolfj.business.product.impl.UpdateWithdrawCase;
import com.github.fabriciolfj.business.usercase.fixture.ProductFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

public class FacadeOperationCaseTest {

    @Mock
    private LinkProductCustomer linkProductCustomer;

    private List<OperationsCase> cases;
    private FacadeOperationCase facadeOperationCase;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        cases = List.of(new UpdateLimitCase(), new UpdateWithdrawCase());
        facadeOperationCase = new FacadeOperationCase(linkProductCustomer, cases);
    }

    @Test
    public void updateUsoProduct() {
        doNothing().when(linkProductCustomer).link(any(), any());
        var product = ProductFixture.productSucess();
        facadeOperationCase.execute(product, BigDecimal.valueOf(200), "99999");

        assertEquals(product.getDailyWithdrawal(), 99);
        assertEquals(product.getLimitDailyWithDrawal(), BigDecimal.valueOf(1000.0));
    }
}
