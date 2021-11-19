package com.github.fabriciolfj.springcontroller;

import com.github.fabriciolfj.OperationServiceApplicationTest;
import com.github.fabriciolfj.controller.model.OperationDto;
import com.github.fabriciolfj.provider.cache.model.ProductCacheDTO;
import com.github.fabriciolfj.template.loader.OperationDtoTemplate;
import com.github.fabriciolfj.template.loader.ProductDtoTemplate;
import com.github.fabriciolfj.wiremock.DebitAccountStub;
import io.restassured.RestAssured;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.http.MediaType;
import wiremock.org.apache.http.HttpStatus;

import static org.hamcrest.Matchers.is;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@DisplayName("Cenarios para teste de operacoes credito/debito")
public class SpringOperationControllerTest extends OperationServiceApplicationTest {

    private static final String URL_DEBIT = "/api/v1/operations/debit";

    @Autowired
    private Cache cache;

    @Test
    @DisplayName("Criar operacao de debito, com sucesso")
    public void testCreatedDebit() {
        final OperationDto dto = OperationDtoTemplate.toRequestValid();
        final ProductCacheDTO cacheDTO = ProductDtoTemplate.toValid();
        cache.put(dto.getAccount(), cacheDTO);

        DebitAccountStub.request(dto.getAccount(), dto.getValue());

        RestAssured
                .given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(dto)
                .post(URL_DEBIT)
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);

    }

    @Test
    @DisplayName("Abortar a criacao da operacao de debito, devido a nao informacao da conta")
    public void testCreatedDebitAccountNotInfo() {
        final OperationDto dto = OperationDtoTemplate.toRequestAccountNotFound();

        DebitAccountStub.request(dto.getAccount(), dto.getValue());

        RestAssured
                .given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(dto)
                .post(URL_DEBIT)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .contentType("application/json")
                .body("details[0].message", is("Codigo da conta não informado."));

    }

    @Test
    @DisplayName("Abortar a criacao da operacao de debito, devido a nao informacao do valor")
    public void testCreatedDebitValueNotInfo() {
        final OperationDto dto = OperationDtoTemplate.toRequestValueNotFound();

        DebitAccountStub.request(dto.getAccount(), dto.getValue());

        RestAssured
                .given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(dto)
                .post(URL_DEBIT)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .contentType("application/json")
                .body("details[0].message", is("Valor invalido"));

    }

    @Test
    @DisplayName("Abortar a criacao da operacao de debito, devido a ausencia de dados")
    public void testCreatedDebitInvalid() {
        final OperationDto dto = OperationDtoTemplate.toRequestInvalid();

        DebitAccountStub.request(dto.getAccount(), dto.getValue());

        RestAssured
                .given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(dto)
                .post(URL_DEBIT)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);

    }
}

