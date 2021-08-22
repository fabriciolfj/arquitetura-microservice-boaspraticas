package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.Extract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FindExtract {

    Optional<Extract> findLast(final String account);

    Page<Extract> findAll(final String account, final Pageable pageable);
}
