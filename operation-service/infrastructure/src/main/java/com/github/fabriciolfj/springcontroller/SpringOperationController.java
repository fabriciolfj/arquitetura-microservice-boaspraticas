package com.github.fabriciolfj.springcontroller;

import com.github.fabriciolfj.controller.CreditController;
import com.github.fabriciolfj.controller.DebitController;
import com.github.fabriciolfj.controller.model.OperationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/operations")
@RequiredArgsConstructor
public class SpringOperationController {

    private final DebitController debitController;
    private final CreditController controller;

    @PostMapping("/debit")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void executeDebit(@RequestBody final OperationDto dto) {
        debitController.execute(dto);
    }

    @PostMapping("/credit")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void executeCredit(@RequestBody final OperationDto dto) {
        controller.create(dto);
    }
}
