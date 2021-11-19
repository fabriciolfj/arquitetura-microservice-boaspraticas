package com.github.fabriciolfj.repository.extract;

import com.github.fabriciolfj.repository.extract.entities.ExtractEntity;
import com.github.fabriciolfj.repository.extract.model.ExtractAccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExtractEntityRepository extends JpaRepository<ExtractEntity, Long> {

    @Query("Select new com.github.fabriciolfj.repository.extract.model.ExtractAccountModel(e.account, e.product) From ExtractEntity e group by e.account, e.product")
    List<ExtractAccountModel> listAccountProduct();

}
