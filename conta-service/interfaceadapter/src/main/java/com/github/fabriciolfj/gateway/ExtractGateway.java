package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.business.FindExtract;
import com.github.fabriciolfj.business.SaveExtract;
import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.entity.exceptions.AccountNotFoundException;
import com.github.fabriciolfj.entity.exceptions.ExtractNotFoundException;
import com.github.fabriciolfj.entity.exceptions.ExtractProcessException;
import com.github.fabriciolfj.repository.conta.ContaEntity;
import com.github.fabriciolfj.repository.conta.ContaRepository;
import com.github.fabriciolfj.repository.extrato.ExtratoEntity;
import com.github.fabriciolfj.repository.extrato.ExtratoRepository;
import com.github.fabriciolfj.repository.extrato.mapper.ExtratoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExtractGateway implements FindExtract, SaveExtract {

    private final ExtratoRepository extratoRepository;
    private final ContaRepository contaRepository;

    @Override
    public Optional<Extract> findLast(final String account) {
        return find(account)
                .map(extrato -> ExtratoMapper.INSTANCE.toDomain(extrato));
    }

    private Optional<ExtratoEntity> find(final String conta) {
        return extratoRepository.findFirstByContaOrderByDateExtratoDesc(conta);
    }

    @Override
    public void save(final Extract extract) {
        var entity = ExtratoMapper.INSTANCE.toEntity(extract);
        extratoRepository.save(entity);
    }
}
