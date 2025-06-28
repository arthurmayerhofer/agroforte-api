package com.agroforte.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.agroforte.domain.model.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
}
