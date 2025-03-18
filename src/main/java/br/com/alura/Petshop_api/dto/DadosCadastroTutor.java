package br.com.alura.Petshop_api.dto;

import jakarta.validation.constraints.Email;

public record DadosCadastroTutor(Long id, String nome, String telefone, String cpf,@Email String email) {
}
