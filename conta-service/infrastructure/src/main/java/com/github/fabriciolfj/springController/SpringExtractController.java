package com.github.fabriciolfj.springController;

import com.github.fabriciolfj.controller.ExtractController;
import com.github.fabriciolfj.entity.exceptions.ExtractNotFoundException;
import com.github.fabriciolfj.entity.exceptions.ExtractProcessException;
import com.github.fabriciolfj.entity.exceptions.model.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/extract")
public class SpringExtractController {

    private final ExtractController extractController;

    @PostMapping("/debit")
    @ResponseStatus(HttpStatus.CREATED)
    public void requestDebit(@RequestParam("value") final BigDecimal value, @RequestParam("code") final String code) {
        extractController.createDebit(code, value);
    }

    @PostMapping("/debit")
    @ResponseStatus(HttpStatus.CREATED)
    public void requestCredit(@RequestParam("value") final BigDecimal value, @RequestParam("code") final String code) {
        extractController.createCredit(code, value);
    }

    @ExceptionHandler(ExtractProcessException.class)
    public ResponseEntity<ErrorMessage> extractProcessException(final ExtractProcessException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorMessage.builder()
                        .code(HttpStatus.BAD_REQUEST.toString())
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(ExtractNotFoundException.class)
    public ResponseEntity<ErrorMessage> extractNotFoundException(final ExtractNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorMessage.builder()
                        .code(HttpStatus.BAD_REQUEST.toString())
                        .message(e.getMessage())
                        .build());
    }
}
