package com.github.fabriciolfj.repository.extrato;

import com.github.fabriciolfj.repository.conta.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExtratoRepository extends JpaRepository<ExtratoEntity, Long> {

    Optional<ExtratoEntity> findFirstByContaOrderByDateExtratoDesc(final String conta);
}
