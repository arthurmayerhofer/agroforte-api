package com.agroforte.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agroforte.api.dto.OperacaoDTO;
import com.agroforte.api.dto.OperacaoResponseDTO;
import com.agroforte.api.dto.ParcelaDTO;
import com.agroforte.domain.model.Operacao;
import com.agroforte.domain.model.Parcela;
import com.agroforte.domain.model.PessoaFisica;
import com.agroforte.domain.repository.OperacaoRepository;
import com.agroforte.domain.repository.PessoaFisicaRepository;
import com.agroforte.domain.service.CalculoFinanceiroService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastrarOperacaoUseCase {

    private final OperacaoRepository operacaoRepository;
    private final PessoaFisicaRepository pessoaFisicaRepository;
    private final CalculoFinanceiroService calculoService;

    public OperacaoResponseDTO executar(OperacaoDTO dto) {
        PessoaFisica pessoa = pessoaFisicaRepository.findById(dto.pessoaId())
            .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));

        Operacao operacao = new Operacao();
        operacao.setPessoa(pessoa);
        operacao.setDataInicio(dto.dataInicio());
        operacao.setDataEmissao(dto.dataEmissao());
        operacao.setDataFim(dto.dataFim());
        operacao.setQuantidadeParcelas(dto.quantidadeParcelas());
        operacao.setTempoCarencia(dto.tempoCarencia());
        operacao.setValorOperacao(dto.valorOperacao());
        operacao.setTaxaMensal(dto.taxaMensal());

        operacao.setDataPrimeiraParcela(
            calculoService.calcularPrimeiraParcela(dto.dataInicio(), dto.tempoCarencia())
        );

        List<Parcela> parcelas = calculoService.gerarParcelas(operacao);
        operacao.setParcelas(parcelas);
        parcelas.forEach(p -> p.setOperacao(operacao));

        Operacao salva = operacaoRepository.save(operacao);

        return toResponseDTO(salva);
    }

    private OperacaoResponseDTO toResponseDTO(Operacao op) {
        return new OperacaoResponseDTO(
            op.getId(),
            op.getDataInicio(),
            op.getValorOperacao(),
            op.getParcelas().stream().map(p -> new ParcelaDTO(
                p.getDataVencimento(),
                p.getValor(),
                p.isPaga()
            )).toList()
        );
    }
}