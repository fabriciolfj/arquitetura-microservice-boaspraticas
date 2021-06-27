package com.github.fabriciolfj.entity;

import com.github.fabriciolfj.entity.exceptions.StatusNotFoundException;
import lombok.AllArgsConstructor;

import static java.util.stream.Stream.of;

@AllArgsConstructor
public enum Status {

    ACTIVE(1), INACTIVE(0);

    private Integer describe;

    public static Status toEnum(final Integer describe) {
        return of(Status.values())
                .filter(p -> p.describe == describe)
                .findFirst()
                .orElseThrow(() -> new StatusNotFoundException("Status not found: " + describe));
    }
}
