package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.business.SaveAccount;
import com.github.fabriciolfj.business.account.FindAccount;
import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.repository.conta.ContaEntity;
import com.github.fabriciolfj.repository.conta.ContaRepository;
import com.github.fabriciolfj.repository.conta.mapper.ContaMapper;
import com.github.fabriciolfj.repository.extrato.ExtratoEntity;
import com.github.fabriciolfj.repository.extrato.mapper.ExtratoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.of;

@Service
@RequiredArgsConstructor
public class ContaGateway implements SaveAccount, FindAccount {

    private final ContaRepository contaRepository;

    @Override
    public Optional<Account> save(Account account) {
        return of(ContaMapper.INSTANCE.toEntity(account))
                .map(c -> {
                    c.setExtratos(toExtratos(account.getExtracts(), c));
                    return c;
                })
                .map(conta -> {
                    contaRepository.save(conta);
                    return account;
                });
    }

    private List<ExtratoEntity> toExtratos(final List<Extract> extracts, final ContaEntity contaEntity) {
        return extracts
                .stream()
                .map(ExtratoMapper.INSTANCE::toEntity)
                .map(entity -> {
                    entity.setConta(contaEntity);
                    return entity;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Account find(String code) {
        return null;
    }
}
