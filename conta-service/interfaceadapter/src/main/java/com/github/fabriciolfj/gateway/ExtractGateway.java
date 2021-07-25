package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.business.CreateExtract;
import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.entity.exceptions.AccountNotFoundException;
import com.github.fabriciolfj.entity.exceptions.ExtractNotFoundException;
import com.github.fabriciolfj.repository.conta.ContaEntity;
import com.github.fabriciolfj.repository.conta.ContaRepository;
import com.github.fabriciolfj.repository.extrato.ExtratoRepository;
import com.github.fabriciolfj.repository.extrato.mapper.ExtratoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ExtractGateway implements CreateExtract {

    private final ExtratoRepository extratoRepository;
    private final ContaRepository contaRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(final Extract extract) {
        contaRepository
                .findByCode(extract.getCodeConta())
                .map(this::findLast)
                .map(extract::calculate)
                .map(ext -> ExtratoMapper.INSTANCE.toEntity(ext))
                .map(extratoRepository::save)
                .orElseThrow(() -> new AccountNotFoundException("Account not found: " + extract.getCodeConta()));
    }

    private Extract findLast(final ContaEntity contaEntity) {
        return extratoRepository.findFirstByContaOrderByDateExtratoDesc(contaEntity)
                .map(entity -> ExtratoMapper.INSTANCE.toDomain(entity))
                .orElseThrow(() -> new ExtractNotFoundException("Extract not found by account: " + contaEntity.getCode()));
    }
}
