package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.business.FindAllExtract;
import com.github.fabriciolfj.business.LinkProductCustomer;
import com.github.fabriciolfj.business.UpdateCache;
import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.providers.cache.CacheProvider;
import com.github.fabriciolfj.repository.extract.ExtractEntityMapper;
import com.github.fabriciolfj.repository.extract.ExtractEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExtractGateway implements LinkProductCustomer, UpdateCache, FindAllExtract {

    private final ExtractEntityRepository extractEntityRepository;
    private final CacheProvider cacheProvider;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void link(final Product product, final String account) {
        save(product, account);
        cacheProvider.add(product, account);
    }

    private void save(final Product product, final String account) {
        var extract = ExtractEntityMapper.INSTANCE.toEntity(product);
        extract.setAccount(account);
        extractEntityRepository.save(extract);
    }

    @Override
    public void execute(final Product product, final String account) {
        cacheProvider.add(product, account);
    }

    @Override
    public List<Extract> findAll() {
        final var extracts = extractEntityRepository.listAccountProduct();
        extracts.forEach(e -> log.info("Account: {}, product: {}", e.getAccount(), e.getProduct()));
        return extracts
                .stream().map(ExtractEntityMapper.INSTANCE::toDomain)
                .collect(Collectors.toList());
    }
}
