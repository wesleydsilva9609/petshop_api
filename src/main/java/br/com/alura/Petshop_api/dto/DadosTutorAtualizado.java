package br.com.alura.Petshop_api.dto;

import jakarta.validation.constraints.Email;

public record DadosTutorAtualizado(Long id, String nome, String telefone, String cpf, @Email String email) {
}
