package com.github.fabriciolfj.repository.extrato;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ExtratoRepository extends PagingAndSortingRepository<ExtratoEntity, Long> {

    Optional<ExtratoEntity> findFirstByContaOrderByDateExtratoDesc(final String conta);

    Page<ExtratoEntity> findByConta(final String account, final Pageable pageable);
}
