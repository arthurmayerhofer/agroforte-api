package com.agroforte.api.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PessoaFisicaDTO {
    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private String celular;
    private String estadoCivil;
    private String genero;
    private LocalDate dataNascimento;
    private String nomeMae;
    private String nacionalidade;
}
