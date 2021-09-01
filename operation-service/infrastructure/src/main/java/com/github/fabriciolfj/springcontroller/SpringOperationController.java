package com.github.fabriciolfj.springcontroller;

import com.github.fabriciolfj.controller.CreditController;
import com.github.fabriciolfj.controller.DebitController;
import com.github.fabriciolfj.controller.model.OperationDto;
import com.github.fabriciolfj.domain.exceptions.BusinessException;
import com.github.fabriciolfj.domain.exceptions.model.Error;
import com.github.fabriciolfj.domain.exceptions.model.ErrorDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/operations")
@RequiredArgsConstructor
@Api(value = "Operation credit or debit", tags = {"Operation"})
public class SpringOperationController {

    private final DebitController debitController;
    private final CreditController creditController;
    private final MessageSource messageSource;

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
    public void executeDebit(@RequestBody @Valid final OperationDto dto) {
        debitController.execute(dto);
    }

    @PostMapping("/credit")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void executeCredit(@RequestBody @Valid final OperationDto dto) {
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Error.builder()
                        .code(HttpStatus.BAD_REQUEST.toString())
                        .message("validação dos campos da requisição")
                        .details(mappingError(e))
                        .build());
    }

    private List<ErrorDetails> mappingError(final MethodArgumentNotValidException e) {
        return e.getBindingResult().getAllErrors()
                .stream().map(obj -> {
                    final String message = messageSource.getMessage(obj, LocaleContextHolder.getLocale());
                    final String name;

                    if (obj instanceof FieldError) {
                        name = ((FieldError) obj).getField();
                    } else {
                        name = obj.getObjectName();
                    }

                    return ErrorDetails
                            .builder()
                            .field(name)
                            .message(message)
                            .build();
                }).collect(Collectors.toList());
    }
}
