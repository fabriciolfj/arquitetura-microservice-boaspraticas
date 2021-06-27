package com.github.fabriciolfj.business.usercase;

import com.github.fabriciolfj.business.SaveProduct;
import com.github.fabriciolfj.business.product.ProductCreateCase;
import com.github.fabriciolfj.business.product.ValidationCase;
import com.github.fabriciolfj.business.usercase.fixture.ProductFixture;
import com.github.fabriciolfj.entity.exceptions.ProductCreateException;
import com.github.fabriciolfj.entity.exceptions.ValidationProductException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class ProductCreateCaseTest {

    private ProductCreateCase createCase;
    @Mock
    private SaveProduct saveProduct;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        createCase = new ProductCreateCase(saveProduct, new ValidationCase());
    }

    @Test
    public void createProductSucess() {
        var product = ProductFixture.productSucess();
        when(saveProduct.save(any())).thenReturn(Optional.of(product));

        var result = createCase.execute(product);

        assertTrue(result != null);
    }

    @Test
    public void createFailProductRateNull() {
        var product = ProductFixture.productRateNull();
        when(saveProduct.save(any())).thenReturn(Optional.of(product));

        assertThrows(ValidationProductException.class, () -> createCase.execute(product));
    }

    @Test
    public void createFailProductBaseOutMakeAir() {
        var product = ProductFixture.productSucess();
        doThrow(RuntimeException.class).when(saveProduct).save(any());

        assertThrows(ProductCreateException.class, () -> createCase.execute(product));
    }
}
