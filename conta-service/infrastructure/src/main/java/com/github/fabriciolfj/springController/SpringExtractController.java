package com.github.fabriciolfj.springController;

import com.github.fabriciolfj.controller.extract.ExtractController;
import com.github.fabriciolfj.controller.extract.model.ExtractResponse;
import com.github.fabriciolfj.entity.exceptions.ExtractNotFoundException;
import com.github.fabriciolfj.entity.exceptions.ExtractProcessException;
import com.github.fabriciolfj.entity.exceptions.model.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api//v1/extract")
public class SpringExtractController {

    private final ExtractController extractController;

    @PostMapping("/debit")
    @ResponseStatus(HttpStatus.CREATED)
    public void requestDebit(@RequestParam("value") final BigDecimal value, @RequestParam("code") final String code) {
        extractController.createDebit(code, value);
    }

    @PostMapping("/credit")
    @ResponseStatus(HttpStatus.CREATED)
    public void requestCredit(@RequestParam("value") final BigDecimal value, @RequestParam("code") final String code) {
        extractController.createCredit(code, value);
    }

    @GetMapping("/{account}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<ExtractResponse> findall(@PageableDefault(size = 20) final Pageable pageable, @PathVariable("account") final String account) {
        return extractController.findExtract(account, pageable);
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
