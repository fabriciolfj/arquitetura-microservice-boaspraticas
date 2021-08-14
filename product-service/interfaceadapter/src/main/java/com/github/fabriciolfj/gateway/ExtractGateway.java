package com.github.fabriciolfj.gateway;

import com.github.fabriciolfj.business.LinkProductCustomer;
import com.github.fabriciolfj.entity.Product;
import com.github.fabriciolfj.providers.cache.UpdateCache;
import com.github.fabriciolfj.repository.extract.ExtractEntityMapper;
import com.github.fabriciolfj.repository.extract.ExtractEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ExtractGateway implements LinkProductCustomer {

    private final ExtractEntityRepository extractEntityRepository;
    private final UpdateCache updateCache;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void link(final Product product, final String account) {
        save(product, account);
        updateCache.add(product, account);
    }

    private void save(final Product product, final String account) {
        var extract = ExtractEntityMapper.INSTANCE.toEntity(product);
        extract.setClient(account);
        extractEntityRepository.save(extract);
    }
}
