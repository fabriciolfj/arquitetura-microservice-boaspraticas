package com.github.fabriciolfj.wiremock;

import lombok.experimental.UtilityClass;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.HashMap;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@UtilityClass
public class DebitAccountStub {

    private static final String URL = "/api/v1/extract/debit";

    public void request(@Nonnull final String account, @Nonnull final BigDecimal value) {
        var uri = UriComponentsBuilder.fromUriString(URL)
                .queryParam("value", value != null ? value.toString() : null)
                .queryParam("code", account)
                .toUriString();

        stubFor(post(uri)
                .willReturn(aResponse()
                .withStatus(204)
                        .withBody("")
                        .withHeader("Content-Type", "appliction/json")));

    }
}
