package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.business.SaveAccount;
import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.repository.conta.ContaRepository;
import com.github.fabriciolfj.repository.conta.mapper.ContaEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContaGateway implements SaveAccount {

    private final ContaRepository contaRepository;

    @Override
    public void save(Account account) {
        contaRepository.save(ContaEntityMapper.INSTANCE.toEntity(account));
    }
}
