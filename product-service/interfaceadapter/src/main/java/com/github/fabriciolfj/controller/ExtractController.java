package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.business.extract.ExtractCase;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExtractController {

    private final ExtractCase extractCase;

    @Scheduled(cron = "* * 23 * * ?" )
    public void reset() {
        extractCase.execute();
    }
}
