package com.github.fabriciolfj.entity.exceptions.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private String field;
    private String message;
}
