package com.agroforte.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroforte.domain.model.Operacao;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
    List<Operacao> findByPessoaId(Long pessoaId);
}
