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
    public void link(final Product product, final String customer) {
        save(product, customer);
        updateCache.add(product, customer);
    }

    private void save(Product product, String customer) {
        var extract = ExtractEntityMapper.INSTANCE.toEntity(product);
        extract.setClient(customer);
        extractEntityRepository.save(extract);
    }
}
