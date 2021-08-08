package com.github.fabriciolfj.springcontroller;

import com.github.fabriciolfj.controller.DebitController;
import com.github.fabriciolfj.controller.model.OperationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/operation")
@RequiredArgsConstructor
public class SpringOperationController {

    private final DebitController debitController;

    @PostMapping("/debit")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void execute(@RequestBody final OperationDto dto) {
        debitController.execute(dto);
    }
}
