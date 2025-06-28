package com.agroforte.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataInicio;
    private LocalDate dataEmissao;
    private LocalDate dataFim;
    private LocalDate dataPrimeiraParcela;
    private int quantidadeParcelas;
    private int tempoCarencia;
    private BigDecimal valorOperacao;
    private BigDecimal taxaMensal;

    @ManyToOne
    private PessoaFisica pessoa;

    @OneToMany(mappedBy = "operacao", cascade = CascadeType.ALL)
    private List<Parcela> parcelas;
}