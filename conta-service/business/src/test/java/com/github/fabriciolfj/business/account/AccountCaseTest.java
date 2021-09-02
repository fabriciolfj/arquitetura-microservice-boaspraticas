package com.github.fabriciolfj.business.account;

import com.github.fabriciolfj.business.LinkProduct;
import com.github.fabriciolfj.business.SaveAccount;
import com.github.fabriciolfj.business.template.AccountTemplate;
import com.github.fabriciolfj.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class AccountCaseTest {

    @Mock
    private LinkProduct linkProduct;

    @Mock
    private SaveAccount saveAccount;

    @InjectMocks
    private AccountCase accountCase;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createAccountSucess() {
        final Account account = new AccountTemplate().getAccountValid();
        when(saveAccount.save(Mockito.any())).thenReturn(Optional.of(account));
        when(linkProduct.linkProduct(account)).thenReturn(account);

        final Account retorno = accountCase.create(account);

        assertTrue(!retorno.getExtracts().isEmpty());
        assertTrue(retorno.getCode() != null);
    }

}
