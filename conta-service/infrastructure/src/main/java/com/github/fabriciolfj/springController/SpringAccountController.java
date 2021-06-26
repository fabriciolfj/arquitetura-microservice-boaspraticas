package com.github.fabriciolfj.springController;

import com.github.fabriciolfj.controller.AccountController;
import com.github.fabriciolfj.controller.model.AccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
@RequiredArgsConstructor
public class SpringAccountController {

    private final AccountController accountController;

    public void create(@RequestBody final AccountRequest request) {
        accountController.create(request);
    }
}
