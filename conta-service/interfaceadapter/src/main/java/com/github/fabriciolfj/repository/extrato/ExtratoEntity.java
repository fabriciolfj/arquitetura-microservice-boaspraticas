package com.github.fabriciolfj.repository.extrato;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "extrato")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ExtratoEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "conta")
    private String conta;
    private BigDecimal debit;
    private BigDecimal credit;
    private BigDecimal balance;
    @Column(name = "date_extrato")
    private LocalDateTime dateExtrato;
}
