package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.business.FindExtract;
import com.github.fabriciolfj.business.SaveExtract;
import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.repository.extrato.ExtratoRepository;
import com.github.fabriciolfj.repository.extrato.mapper.ExtratoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExtractGateway implements FindExtract, SaveExtract {

    private final ExtratoRepository extratoRepository;

    @Override
    public Optional<Extract> findLast(final String account) {
        return extratoRepository.findFirstByContaOrderByDateExtratoDesc(account)
                .map(extrato -> ExtratoMapper.INSTANCE.toDomain(extrato));
    }

    @Override
    public void save(final Extract extract) {
        var entity = ExtratoMapper.INSTANCE.toEntity(extract);
        extratoRepository.save(entity);
    }

    public void saveExtrato(final Account account) {
        var extrato = ExtratoMapper.INSTANCE.toEntity(account.findFirst());
        extratoRepository.save(extrato);
    }
}
