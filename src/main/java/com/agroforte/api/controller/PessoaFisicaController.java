package com.agroforte.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroforte.api.dto.PessoaFisicaDTO;
import com.agroforte.application.usecase.CadastrarPessoaFisicaUseCase;
import com.agroforte.domain.model.PessoaFisica;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pessoas-fisicas")
@RequiredArgsConstructor
public class PessoaFisicaController {

    private final CadastrarPessoaFisicaUseCase useCase;

    @PostMapping
    public ResponseEntity<PessoaFisica> cadastrar(@RequestBody @Valid PessoaFisicaDTO dto) {
        PessoaFisica pessoa = useCase.executar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }
}
