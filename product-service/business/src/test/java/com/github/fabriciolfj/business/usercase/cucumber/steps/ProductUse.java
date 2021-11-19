package com.github.fabriciolfj.business.usercase.cucumber.steps;

import com.github.fabriciolfj.business.LinkProductCustomer;
import com.github.fabriciolfj.business.product.FacadeOperationCase;
import com.github.fabriciolfj.business.product.OperationsCase;
import com.github.fabriciolfj.business.product.impl.UpdateLimitCase;
import com.github.fabriciolfj.business.product.impl.UpdateWithdrawCase;
import com.github.fabriciolfj.business.usercase.cucumber.steps.mapper.ProductMapper;
import com.github.fabriciolfj.entity.Product;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductUse {

    @Mock
    private LinkProductCustomer linkProductCustomer;

    private List<OperationsCase> cases;
    private FacadeOperationCase facadeOperationCase;
    private Product product;
    private Double valor;
    private String customer;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        cases = List.of(new UpdateLimitCase(), new UpdateWithdrawCase());
        facadeOperationCase = new FacadeOperationCase(linkProductCustomer, cases);
    }

    @Dado("um produto")
    public void um_produto(DataTable dataTable) {
        product = ProductMapper.toProduct(dataTable);
    }

    @Dado("um saque {double} para cliente {string}")
    public void um_saque_para_cliente(Double saque, String customer) {
        this.valor = saque;
        this.customer = customer;
    }

    @Quando("realizar uso do produto")
    public void realizar_uso_do_produto() {
        this.product = facadeOperationCase.execute(this.product, BigDecimal.valueOf(valor), customer);
    }

    @Entao("deve contabilizar o uso do saque e saldo")
    public void deve_contabilizar_o_uso_do_saque_e_saldo() {
        assertEquals(product.getDailyWithdrawal(), 4);
        assertTrue(product.getLimitDailyWithDrawal().compareTo(BigDecimal.valueOf(50.0)) == 0);
    }
}
