package com.agroforte.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ParcelaDTO(
    LocalDate dataVencimento,
    BigDecimal valor,
    boolean paga
) {}