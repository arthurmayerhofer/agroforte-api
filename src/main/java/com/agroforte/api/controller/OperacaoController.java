package com.agroforte.api.controller;

import com.agroforte.api.dto.OperacaoDTO;
import com.agroforte.api.dto.OperacaoResponseDTO;
import com.agroforte.application.usecase.CadastrarOperacaoUseCase;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operacoes")
@RequiredArgsConstructor
public class OperacaoController {

    private final CadastrarOperacaoUseCase useCase;

    @PostMapping
    public ResponseEntity<OperacaoResponseDTO> criar(@RequestBody OperacaoDTO dto) {
        return ResponseEntity.ok(useCase.executar(dto));
    }
}
