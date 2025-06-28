package com.agroforte.application.usecase;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.agroforte.api.dto.PessoaFisicaDTO;
import com.agroforte.domain.model.PessoaFisica;
import com.agroforte.domain.repository.PessoaFisicaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastrarPessoaFisicaUseCase {

    private final PessoaFisicaRepository repository;

    public PessoaFisica executar(PessoaFisicaDTO dto) {
        PessoaFisica pessoa = new PessoaFisica();
        BeanUtils.copyProperties(dto, pessoa);  // alternativa: MapStruct
        return repository.save(pessoa);
    }
}
