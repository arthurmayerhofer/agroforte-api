package com.agroforte.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroforte.domain.model.Parcela;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {
}