package com.github.fabriciolfj.springcontroller;

import com.github.fabriciolfj.controller.CreditController;
import com.github.fabriciolfj.controller.DebitController;
import com.github.fabriciolfj.controller.model.OperationDto;
import com.github.fabriciolfj.domain.exceptions.BusinessException;
import com.github.fabriciolfj.domain.exceptions.model.Error;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/operations")
@RequiredArgsConstructor
@Api(value = "Operation credit or debit", tags = {"Operation"})
public class SpringOperationController {

    private final DebitController debitController;
    private final CreditController creditController;

    @ApiOperation(
            value = "Create operation debit",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 204, message = "Content created")
            }
    )
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
