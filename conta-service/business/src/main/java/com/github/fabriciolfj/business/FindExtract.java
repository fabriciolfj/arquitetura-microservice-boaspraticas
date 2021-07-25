package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.Extract;

import java.util.Optional;

public interface FindExtract {

    Optional<Extract> findLast(final String account);
}
