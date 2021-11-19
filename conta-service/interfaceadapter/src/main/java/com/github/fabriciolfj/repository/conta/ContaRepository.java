package com.github.fabriciolfj.repository.conta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<ContaEntity, Long> {

    Optional<ContaEntity> findByCode(final String code);

    Optional<ContaEntity> findByCpf(final String cpf);
}
