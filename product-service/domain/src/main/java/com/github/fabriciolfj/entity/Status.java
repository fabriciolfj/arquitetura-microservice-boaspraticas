package com.github.fabriciolfj.entity;

import com.github.fabriciolfj.entity.exceptions.StatusNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.util.stream.Stream.of;

@Getter
@AllArgsConstructor
public enum Status {

    ACTIVE(1), INACTIVE(0);

    private Integer code;

    public static Status toEnum(final Integer code) {
        return of(Status.values())
                .filter(p -> p.code == code)
                .findFirst()
                .orElseThrow(() -> new StatusNotFoundException("Status not found, code: " + code));
    }
}
