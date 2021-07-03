package com.github.fabriciolfj.repository;

import com.github.fabriciolfj.repository.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}