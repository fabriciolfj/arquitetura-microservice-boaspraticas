package com.github.fabriciolfj.repository.extract.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtractAccountModel {

    private String account;
    private String product;
}
