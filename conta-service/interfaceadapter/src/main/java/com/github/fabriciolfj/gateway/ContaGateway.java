package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.business.FindAccount;
import com.github.fabriciolfj.business.SaveAccount;
import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.repository.conta.ContaRepository;
import com.github.fabriciolfj.repository.conta.mapper.ContaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Optional.of;

@Service
@RequiredArgsConstructor
public class ContaGateway implements SaveAccount, FindAccount {

    private final ContaRepository contaRepository;
    private final ExtractGateway extractGateway;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<Account> save(Account account) {
        return of(ContaMapper.INSTANCE.toEntity(account))
                .map(conta -> {
                    contaRepository.save(conta);
                    extractGateway.saveExtrato(account);
                    return account;
                });
    }

    @Override
    public Optional<Account> findAccountByCPF(final String cpf) {
        return contaRepository.findByCpf(cpf)
                .map(ContaMapper.INSTANCE::toDomain);
    }

}
