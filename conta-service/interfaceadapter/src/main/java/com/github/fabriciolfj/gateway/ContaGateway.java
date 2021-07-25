package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.business.SaveAccount;
import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.repository.conta.ContaRepository;
import com.github.fabriciolfj.repository.conta.mapper.ContaMapper;
import com.github.fabriciolfj.repository.extrato.ExtratoRepository;
import com.github.fabriciolfj.repository.extrato.mapper.ExtratoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Optional.of;

@Service
@RequiredArgsConstructor
public class ContaGateway implements SaveAccount {

    private final ContaRepository contaRepository;
    private final ExtratoRepository extratoRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<Account> save(Account account) {
        return of(ContaMapper.INSTANCE.toEntity(account))
                .map(conta -> {
                    contaRepository.save(conta);
                    saveExtrato(account);
                    return account;
                });
    }

    private void saveExtrato(final Account account) {
        var extrato = ExtratoMapper.INSTANCE.toEntity(account.findFirst());
        extratoRepository.save(extrato);
    }
}
