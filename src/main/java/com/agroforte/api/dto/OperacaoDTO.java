package com.agroforte.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record OperacaoDTO(
    Long pessoaId,
    LocalDate dataInicio,
    LocalDate dataEmissao,
    LocalDate dataFim,
    int quantidadeParcelas,
    int tempoCarencia,
    BigDecimal valorOperacao,
    BigDecimal taxaMensal
) {}