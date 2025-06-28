package com.agroforte.domain.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.agroforte.domain.model.Operacao;
import com.agroforte.domain.model.Parcela;

@Service
public class CalculoFinanceiroService {

    public LocalDate calcularPrimeiraParcela(LocalDate dataInicio, int tempoCarencia) {
        return dataInicio.plusMonths(tempoCarencia);
    }

    public BigDecimal calcularValorParcela(Operacao operacao) {
        BigDecimal taxa = operacao.getTaxaMensal().divide(BigDecimal.valueOf(100), 8, RoundingMode.HALF_UP);
        BigDecimal fator = taxa.add(BigDecimal.ONE).pow(operacao.getQuantidadeParcelas());
        return operacao.getValorOperacao()
                .multiply(fator)
                .divide(BigDecimal.valueOf(operacao.getQuantidadeParcelas()), 2, RoundingMode.HALF_UP);
    }

    public List<Parcela> gerarParcelas(Operacao operacao) {
        BigDecimal valorParcela = calcularValorParcela(operacao);
        List<Parcela> parcelas = new ArrayList<>();

        for (int i = 0; i < operacao.getQuantidadeParcelas(); i++) {
            Parcela p = new Parcela();
            p.setDataVencimento(operacao.getDataPrimeiraParcela().plusMonths(i));
            p.setValor(valorParcela);
            p.setPaga(false);
            parcelas.add(p);
        }

        return parcelas;
    }
}