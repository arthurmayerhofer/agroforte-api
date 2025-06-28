package com.agroforte.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record OperacaoResponseDTO(
    Long id,
    LocalDate dataInicio,
    BigDecimal valorOperacao,
    List<ParcelaDTO> parcelas
) {}