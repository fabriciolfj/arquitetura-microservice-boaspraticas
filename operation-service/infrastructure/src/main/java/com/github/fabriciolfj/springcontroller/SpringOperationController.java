package com.github.fabriciolfj.springcontroller;

import com.github.fabriciolfj.controller.CreditController;
import com.github.fabriciolfj.controller.DebitController;
import com.github.fabriciolfj.controller.model.OperationDto;
import com.github.fabriciolfj.domain.exceptions.BusinessException;
import com.github.fabriciolfj.domain.exceptions.model.Error;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/operations")
@RequiredArgsConstructor
public class SpringOperationController {

    private final DebitController debitController;
    private final CreditController creditController;

    @PostMapping("/debit")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void executeDebit(@RequestBody final OperationDto dto) {
        debitController.execute(dto);
    }

    @PostMapping("/credit")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void executeCredit(@RequestBody final OperationDto dto) {
        creditController.create(dto);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Error> businessExceptionHandleR(final BusinessException e) {
        final var error = Error.builder()
                .code(HttpStatus.BAD_REQUEST.toString())
                .message(e.getMessage())
                .build();

        return ResponseEntity.badRequest().body(error);
    }
}
