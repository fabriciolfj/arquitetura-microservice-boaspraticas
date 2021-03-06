package com.github.fabriciolfj.application.springcontroller;


import com.github.fabriciolfj.controller.ProductController;
import com.github.fabriciolfj.controller.model.GetProductRequest;
import com.github.fabriciolfj.controller.model.GetProductResponse;
import com.github.fabriciolfj.entity.exceptions.BusinessException;
import com.github.fabriciolfj.entity.exceptions.ProductNotFoundException;
import com.github.fabriciolfj.entity.exceptions.model.Error;
import com.github.fabriciolfj.entity.exceptions.model.ErrorDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class SpringProductController {

    private final ProductController controller;
    private final MessageSource messageSource;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GetProductResponse create(@Valid @RequestBody final GetProductRequest request) {
        return controller.process(request);
    }

    @GetMapping("/{describe}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public GetProductResponse find(@PathVariable final String describe) {
        return controller.findDescribeProduct(describe);
    }

    @GetMapping("/{value}/{code}/link")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public GetProductResponse find(@PathVariable final BigDecimal value, @PathVariable("code") final String codeClient) {
        return controller.findProduct(value, codeClient);
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity handleProductNotFound(final ProductNotFoundException e) {
        return ResponseEntity
                .badRequest()
                .body(Error.builder()
                        .message(e.getMessage())
                        .code(HttpStatus.BAD_REQUEST.toString())
                        .build());
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity handleBusiness(final BusinessException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Error
                        .builder()
                        .message(e.getMessage())
                        .code(HttpStatus.BAD_REQUEST.toString())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Error.builder()
                        .code(HttpStatus.BAD_REQUEST.toString())
                        .message("valida????o dos campos da requisi????o")
                        .details(mappingError(e))
                        .build());
    }

    private List<ErrorDetails> mappingError(final MethodArgumentNotValidException e) {
        return e.getBindingResult().getAllErrors()
                .stream().map(obj -> {
                    String message = messageSource.getMessage(obj, LocaleContextHolder.getLocale());
                    String name = obj.getObjectName();

                    if (obj instanceof FieldError) {
                        name = ((FieldError) obj).getField();
                    }

                    return ErrorDetails
                            .builder()
                            .field(name)
                            .message(message)
                            .build();
                }).collect(Collectors.toList());
    }
}
