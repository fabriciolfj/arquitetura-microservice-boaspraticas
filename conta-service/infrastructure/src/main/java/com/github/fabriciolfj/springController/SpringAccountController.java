package com.github.fabriciolfj.springController;

import com.github.fabriciolfj.controller.AccountController;
import com.github.fabriciolfj.controller.model.AccountRequest;
import com.github.fabriciolfj.controller.model.AccountResponse;
import com.github.fabriciolfj.entity.exceptions.AccountNotFoundException;
import com.github.fabriciolfj.entity.exceptions.DomainException;
import com.github.fabriciolfj.entity.exceptions.ProductClientException;
import com.github.fabriciolfj.entity.exceptions.model.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1/account")
public class SpringAccountController {

    @Autowired
    private AccountController accountController;

    @PostMapping
    public void create(@RequestBody @Valid final AccountRequest request) {
        accountController.create(request);
    }

    @GetMapping("/{cpf}")
    public AccountResponse create(@RequestBody @NotNull @PathVariable("cpf") final String cpf) {
        return accountController.findAccount(cpf);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorMessage> domainExceptionHandler(final DomainException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorMessage.builder()
                        .code(HttpStatus.BAD_REQUEST.toString())
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorMessage> domainAccountNotFoundException(final AccountNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorMessage.builder()
                        .code(HttpStatus.BAD_REQUEST.toString())
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(ProductClientException.class)
    public ResponseEntity<ErrorMessage> productClientException(final ProductClientException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorMessage.builder()
                        .code(HttpStatus.BAD_REQUEST.toString())
                        .message(e.getMessage())
                        .build());
    }


}
