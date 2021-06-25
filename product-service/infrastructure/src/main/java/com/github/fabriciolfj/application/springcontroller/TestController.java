package com.github.fabriciolfj.application.springcontroller;

import com.github.fabriciolfj.entity.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/test")
public class TestController {

    @GetMapping
    public Example get() {
        return new Example("Fabricio");
    }
}
