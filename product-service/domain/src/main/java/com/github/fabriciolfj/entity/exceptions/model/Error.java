package com.github.fabriciolfj.entity.exceptions.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Error {

    private String code;
    private String message;
    private List<ErrorDetails> details;
}
