package com.github.fabriciolfj.springController;

import com.github.fabriciolfj.controller.AccountController;
import com.github.fabriciolfj.controller.model.AccountRequest;
import com.github.fabriciolfj.entity.exceptions.DomainException;
import com.github.fabriciolfj.entity.exceptions.model.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/account")
public class SpringAccountController {

    @Autowired
    private AccountController accountController;

    @PostMapping
    public void create(@RequestBody @Valid final AccountRequest request) {
        accountController.create(request);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorMessage> domainExceptionHandler(final DomainException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorMessage.builder()
                        .code(HttpStatus.BAD_REQUEST.toString())
                        .message(e.getMessage())
                        .build());
    }
}
